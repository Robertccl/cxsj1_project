#pragma once

#include <iostream>
#include <fstream>
#include "My_fstream.h"
#include <string>
#include <queue>
#include <list>
#include <time.h>
#include "SMIS_MARK.h"
using namespace std;

typedef char FLAG;

template<class T>
class SMIS
{
public:
	SMIS();
	~SMIS();

	FLAG Run();
	
private:
	list<T> m_data;
	int m_iYearMonth;
	int m_iNumber;

	SMIS(const SMIS<T>& rhs);
	SMIS<T>& operator=(const SMIS<T>& rhs);
	
	
	FLAG Add();
	string BuildingNumber();
	FLAG Search();
	FLAG Find(const string & key, typename list<T>::iterator &iter);
	bool Find(T& key);
	FLAG Change();
	FLAG Delete();
	void Log(const char *operation);

	void ShowInformation(typename list<T>::iterator & iter);//��̬����
	void ShowMenu();//��̬����
	
	//void Prompt(int choose);

	FLAG ReadFile();
	FLAG WriteFile();
};

template<class T>
  void SMIS<T>::ShowInformation(typename list<T>::iterator & iter)
{
	T temp = *iter;
	temp.ShowInformation(temp);
}

template<class T>
  void SMIS<T>::ShowMenu()
{
	T temp;
	temp.ShowMenu();
}

 

/*
template<class T>
  void SMIS<T>::Prompt(int choose)
{
	switch (choose)
	{
	case SMIS_OPEN_FILE_FAILED:
		cout << "���ļ�ʧ��..." << endl;
		break;
	case SMIS_READ_FILE_FAILED:
		cout << "��ȡ�ļ�ʧ��..." << endl;
		break;
	case SMIS_WRITE_FILE_FAILED:
		cout << "�����ļ�ʧ��..." << endl;
		break;
	case SMIS_LANDING_FAILED:
		cout << "ȡ����½..." << endl;
		break;
	case SMIS_ADD_AGAIN:
		cout << "������ӣ�(�� 1 /�� 0)" ;
		break;
	case SMIS_SEARCH_NAME_OR_NUMBER:
		cout << "���������ֻ��ţ�";
		break;
	case SMIS_SEARCH_FAILED:
		cout << "����ʧ��..." << endl;
		break;
	case SMIS_FIND_FAILED:
		cout << "û����Ҫ�ҵ�����..." << endl;
		break;
	case SMIS_SEARCH_AGAIN:
		cout << "�������ң�(�� 1 /�� 0)";
		break;
	case SMIS_FIND_NUMBER:
		cout << "�Ѿ��ҵ�..." << endl;
		break;
	case SMIS_CHANGE_NAME_OR_NUMBER:
		cout << "���������ֻ��ţ�";
		break;
	case SMIS_CHANGE_FAILED:
		cout << "����ʧ��..." << endl;
		break;
	case SMIS_CHANGE_AGAIN:
		cout << "�������ģ�(�� 1 /�� 0)";
		break;
	case SMIS_DELETE_NAME_OR_NUMBER:
		cout << "���������ֻ��ţ�";
		break;
	case SMIS_DELETE_FAILED:
		cout << "ɾ��ʧ��..." << endl;
		break;
	case SMIS_DELETE_CONFIRMED:
		cout << "ȷ��ɾ����(�� 1 /�� 0)";
		break;
	case SMIS_DELETE_AGAIN:
		cout << "����ɾ����(�� 1 /�� 0)";
		break;
	case SMIS_DELETE_SUCCESS:
		cout << "ɾ���ɹ�..." << endl;
		break;
	case SMIS_CHOOSE_NUMBER:
		cout << "��ѡ��ɾ������ţ�" << endl;
		break;
	
	default:break;
	}
}
*/

template<class T>
  FLAG SMIS<T>::ReadFile()
{
	T temp;
	fstream file;
	//file.open(T::FileID, ios::_Nocreate);
	file = temp.Open(ios::in | ios::_Nocreate);
	if (!file.is_open())
	{
		cout << "���ļ�ʧ��..." << endl;
		return SMIS_OPEN_FILE_FAILED;
	}
	file.seekg(ios::beg);
	file >> m_iYearMonth;
	file >> m_iNumber;
	file >> m_data;
	if (file.fail())
	{
		cout << "��ȡ�ļ�ʧ��..." << endl;
		//file.close();
		return SMIS_READ_FILE_FAILED;
	}
	file.close();
	return SMIS_READ_FILE_SUCCESS;
}

template<class T>
  FLAG SMIS<T>::WriteFile()
{
	T temp;
	fstream file;
	//file.open(T::FileID, ios::trunc);
	file = temp.Open(ios::out | ios::trunc);
	if (!file.is_open())
	{
		cout << "���ļ�ʧ��..." << endl;
		return SMIS_OPEN_FILE_FAILED;
	}
	file.seekp(ios::beg);
	file << m_iYearMonth << ' ';
	file << m_iNumber << ' ';
	file << m_data;
	if (file.fail())
	{
		cout << "�����ļ�ʧ��..." << endl;
		file.close();
		return SMIS_WRITE_FILE_FAILED;
	}
	file.close();
	return SMIS_WRITE_FILE_SUCCESS;
}

template<class T>
  SMIS<T>::SMIS(const SMIS<T>& rhs)
{
}
template<class T>
  SMIS<T>& SMIS<T>::operator=(const SMIS<T>& rhs)
{
	return *this;
}

template<class T>
  SMIS<T>::SMIS()
{
}

template<class T>
  SMIS<T>::~SMIS()
{
}

template<class T>
  FLAG SMIS<T>::Run()
{
	FLAG flag;
	flag = ReadFile();
	if (SMIS_READ_FILE_FAILED == flag
		|| SMIS_OPEN_FILE_FAILED == flag)
		exit(0);

	char choose;
	do
	{
		ShowMenu();
		cin.clear();
		cin.sync();
		cin >> choose;
		choose -= '0';

		switch ((int)choose)
		{
		case SMIS_ADD:
			Add();
			break;
		case SMIS_SEARCH:
			Search();
			break;
		case SMIS_CHANGE:
			Change();
			break;
		case SMIS_DELETE:
			Delete();
			break;
		case SMIS_RETURN:
			//Prompt(LANDING_FAILED);
			flag = WriteFile();
			if (SMIS_WRITE_FILE_FAILED == flag
				|| SMIS_OPEN_FILE_FAILED == flag)
				exit(0);
			return SMIS_SUCCESS;
		default:break;
		}
	} while (true);

	/*
		flag = WriteFile();
		if (SMIS_WRITE_FILE_FAILED == flag
			|| SMIS_OPEN_FILE_FAILED == flag)
			exit(0);
	*/
}

template<class T>
  FLAG SMIS<T>::Add()
{
	char choose;
	system("cls");
	do {
		T temp;
		temp.Input(temp);
		if (false == Find(temp))
		{
			temp.number=BuildingNumber();
			m_data.push_back(temp);
		}
		else cout << "�Ѵ��ڴ˶���" << endl;

		cout << "\t\t���������Ա��(�� 1 /�� 0)";
		cin.clear();
		cin.sync();
		cin >> choose;
		choose -= '0';
	} while ((int)choose == SMIS_ADD_AGAIN);

	return SMIS_ADD_SUCCESS;
}

template<class T>
  string SMIS<T>::BuildingNumber()
{
	string num;
	num = "";
	time_t timep;
	struct tm *pTemp;
	time(&timep);
	pTemp = localtime(&timep);
	if (pTemp->tm_year * 100 + pTemp->tm_mon != m_iYearMonth)
	{
		m_iYearMonth = pTemp->tm_year * 100 + pTemp->tm_mon;
		m_iNumber = 0;
	}

	//num += ;

	m_iNumber++;
	return num;
}

template<class T>
  FLAG SMIS<T>::Search()
{
	char choose;
	string nameOrNumber;
	typename list<T>::iterator iter;
	do
	{
		cout << "���������ֻ��ţ�";
		cin >> nameOrNumber;
		if ("x" == nameOrNumber || "X" == nameOrNumber)
		{
			cout << "����ʧ��..." << endl;
			return SMIS_SEARCH_FAILED;
		}
		if (SMIS_FIND_FAILED == Find(nameOrNumber,iter))
		{
			cout << "û����Ҫ�ҵ�����..." << endl;
		}
		ShowInformation(iter);
		cout << "�������ң�(�� 1 /�� 0)";
		cin.clear();
		cin.sync();
		cin >> choose;
		choose -= '0';
	} while (SMIS_SEARCH_AGAIN == (int)choose);
	
	return SMIS_SEARCH_SUCCESS;
}

template<class T>
  FLAG SMIS<T>::Find(const string & key,typename list<T>::iterator &iter)
{
	int n = 1;
	queue<typename list<T>::iterator> iter_queue;
	if (!m_data.empty())
	{
		iter = m_data.begin();
		//for (iter = m_data.begin(); iter != m_data.end(); iter++)
		do
		{
			/*if (key== iter->number)
			{
				ShowInformation(iter);
				cout << "�Ѿ��ҵ�..." << endl;
				return SMIS_FIND_NUMBER;
			}*/
			if (key == iter->name)
			{
				cout << n++ << ".";
				ShowInformation(iter);
				iter_queue.push(iter);
			}
		} while (iter++ != m_data.end());
		if (iter_queue.size() > 1)
		{
			cout << "������ѡ�����ţ�" << endl;

			//typename queue<typename list<T>::iterator>::iterator iterTemp;
			//while(!iter_queue.empty())
		/*	for (iterTemp = iter_queue.begin(); iterTemp != iter_queue.end(); iterTemp++)
			{
				if (key == (*iterTemp).number)
				{
					ShowInformation(iterTemp);
					iter = *iterTemp;
					cout << "�Ѿ��ҵ�..." << endl;
					return SMIS_FIND_NUMBER;
				}
			}
		*/
		//typename list<T>::iterator iterTemp;
			while (--n)
				iter_queue.pop();
			iter = iter_queue.front();
			cout << "�Ѿ��ҵ�..." << endl;
			return SMIS_FIND_NUMBER;
		}
		else iter = iter_queue.front();
	}
	cout << "û����Ҫ�ҵ�����..." << endl;
	return SMIS_FIND_FAILED;
}

  template<class T>
  bool SMIS<T>::Find(T& key)
  {
	  typename list<T>::iterator iter;
	  if (!m_data.empty())
	  {
		  //for (iter = m_data.begin(); iter != m_data.end(); iter++)
		  iter = m_data.begin(); 
		  do
		  {
			  if (key.name == iter->name)
			  {
				  if (key == (*iter))
					  return true;
			  }
		  } while (iter++ != m_data.end());
	  }
	  return false;
  }


template<class T>
  FLAG SMIS<T>::Change()
{
	T temp;
	char choose;
	string nameOrNumber;
	typename list<T>::iterator iter;
	do
	{
		cout << "���������ֻ��ţ�";
		cin >> nameOrNumber;
		if ("x" == nameOrNumber || "X" == nameOrNumber)
		{
			cout << "����ʧ��..." << endl;
			return SMIS_CHANGE_FAILED;
		}
		if (SMIS_FIND_FAILED == Find(nameOrNumber, iter))
		{
			cout << "û����Ҫ�ҵ�����..." << endl;
		}

		temp.ShowChooseMenu();
		cin.clear();
		cin.sync();
		cin >> choose;
		choose -= '0';
		temp.Change(*iter, (int)choose);

		cout << "�������ģ�(�� 1 /�� 0)";
		cin.clear();
		cin.sync();
		cin >> choose;
		choose -= '0';
	} while (SMIS_CHANGE_AGAIN == (int)choose);

	return SMIS_CHANGE_SUCCESS;
}

template<class T>
  FLAG SMIS<T>::Delete()
{
	char choose;
	string nameOrNumber;
	typename list<T>::iterator iter;
	do
	{
		cout << "���������ֻ��ţ�";
		cin >> nameOrNumber;
		if ("x" == nameOrNumber || "X" == nameOrNumber)
		{
			cout << "ɾ��ʧ��..." << endl;
			return SMIS_DELETE_FAILED;
		}
		if (SMIS_FIND_FAILED == Find(nameOrNumber, iter))
		{
			cout << "û����Ҫ�ҵ�����..." << endl;
		}
		else
		{
			cout << "ȷ��ɾ����(�� 1 /�� 0)";
			cin.clear();
			cin.sync();
			cin >> choose;
			choose -= '0';
			if (SMIS_DELETE_CONFIRMED == (int)choose)
			{
				m_data.erase(iter);
				cout << "ɾ���ɹ�..." << endl;
				//else cout << "ɾ��ʧ��..." << endl;
			}
		}

		cout << "����ɾ����(�� 1 /�� 0)";
		cin.clear();
		cin.sync();
		cin >> choose;
		choose -= '0';
	} while (SMIS_DELETE_AGAIN == (int)choose);

	return SMIS_DELETE_SUCCESS;
}

template<class T>
  void SMIS<T>::Log(const char * operation)
{
	time_t timep;
	struct tm *pTemp;
	time(&timep);
	pTemp = localtime(&timep);
	fstream LogFile;
	LogFile.open("log.txt", ios_base::app);
		
	LogFile << "��" << pTemp->tm_year + 1900 << "��" << pTemp->tm_mon << "��" << pTemp->tm_mday << "��";
	LogFile << pTemp->tm_hour << "ʱ" << pTemp->tm_min << "��" << pTemp->tm_sec << "��" << "������" << endl;
	LogFile << operation << endl;
	LogFile.close();
}

