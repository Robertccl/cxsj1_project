#include "Password.h"

PASSWORD::PASSWORD()
{
	FLAG flag;
	flag = ReadFile();
	if (PASSWORD_READ_FILE_FAILED == flag
		|| PASSWORD_OPEN_FILE_FAILED == flag)
		exit(0);
}

PASSWORD::~PASSWORD()
{
}

void PASSWORD::ShowMenu()
{
	system("cls"); /*����*/
	cout << "\t\t ======================================" << endl;
	cout << "\t\t��            �������ϵͳ            ��" << endl;
	cout << "\t\t ======================================" << endl;
	cout << "\t\t   ����������������������������������" << endl;
	cout << "\t\t   �� 1.��������     2.��½ϵͳ    ��" << endl;
	cout << "\t\t   ��                              ��" << endl;
	cout << "\t\t   �� 3.�˳�ϵͳ                   ��" << endl;
	cout << "\t\t   ����������������������������������" << endl;
}

FLAG PASSWORD::Input(string &newPassword)
{
	//Prompt(INPUT);
	cin >> newPassword;
	if (cin.fail())
	{
		cout << "����������(ȡ����½:x):	";
		return PASSWORD_INPUT_FAILED;
	}
	if (newPassword == "x" || newPassword == "X")
	{
		cout << "��������ʧ��!!!" << endl;
		return PASSWORD_INPUT_FAILED;
	}
	//��������Ƿ�ȫ
	return PASSWORD_INPUT_SUCCESS;
}

FLAG PASSWORD::ReSet()
{
	FLAG flag;
	string oldPassword;
	
	do
	{
		cout << "�����������(ȡ����½:x):	";
		if (PASSWORD_INPUT_FAILED == Input(oldPassword))
		{
			cout << "��������ʧ��!!!" << endl;
			return PASSWORD_RESET_FAILED;
		}
	} while (PASSWORD_MATCH_FAILED == Match(oldPassword));

	string newPassword;
	string newPassword_2;

	do
	{
		cout << "������������(ȡ����½:x):	";
		if (PASSWORD_INPUT_FAILED == Input(newPassword))
		{
			cout << "��������ʧ��!!!" << endl;
			return PASSWORD_RESET_FAILED;
		}

		cout << "��ȷ��������(ȡ����½:x):	";
		if (PASSWORD_INPUT_FAILED == Input(newPassword_2))
		{
			cout << "��������ʧ��!!!" << endl;
			return PASSWORD_RESET_FAILED;
		}
		
	} while (newPassword != newPassword_2);

	//m_sPassword = Encrypt(newPassword);

	flag = WriteFile();
	if (PASSWORD_WRITE_FILE_FAILED == flag
		|| PASSWORD_OPEN_FILE_FAILED == flag)
		exit(0);

	cout << "�������óɹ�!!!" << endl;
	return PASSWORD_RESET_SUCCESS;
}

FLAG PASSWORD::Landing()
{
	string password;

	do
	{
		cout << "����������(ȡ����½:x):	";
		if (PASSWORD_INPUT_FAILED == Input(password))
		{
			return PASSWORD_INPUT_FAILED;
		}
	} while (PASSWORD_MATCH_FAILED == Match(password));

	cout << "��½�ɹ�..." << endl;
	return PASSWORD_LANDING_SUCCESS;
}

FLAG PASSWORD::Run()
{
	
	char choose;
	ShowMenu();
	cin.clear();
	cin.sync();
	cin >> choose;
	choose -= '0';
	switch ((int)choose)
	{
	case PASSWORD_RESET:
		ReSet();
		break;
	case PASSWORD_LANDING:
		Landing();
		break;
	case PASSWORD_LOG_OUT:
		cout << "ȡ����½..." << endl;
		return PASSWORD_LANDING_FAILED;
	default:break;
	}
	return PASSWORD_SUCCESS;
}

FLAG PASSWORD::Match(const string password)
{
	//password = Encrypt(password);
	if (m_sPassword == password)
	{
		cout << "������ȷ�����ڵ�½..." << endl;
		return PASSWORD_MATCH_SUCCESS;
	}
	cout << "�������!!!" << endl;
	return PASSWORD_MATCH_FAILED;
}

/*

bool PASSWORD::Prompt(int choose)
{
	switch (choose)
	{
	case INPUT_PASSWORD:
		cout << "����������(ȡ����½:x):	";
		break;
	case INPUT_NEW_PASSWORD:
		cout << "������������(ȡ����½:x):	";
		break;
	case INPUT_OLD_PASSWORD:
		cout << "�����������(ȡ����½:x):	";
		break;
	case INPUT_NEW_PASSWORD_AGAIN:
		cout << "��ȷ��������(ȡ����½:x):	";
		break;
	case INPUT_FAILED:
		cout << "��������ʧ��!!!" << endl;
		break;
	case RESET_SUCCESS:
		cout << "�������óɹ�!!!" << endl;
		break;
	case RESET_FAILED:
		cout << "��������ʧ��!!!" << endl;
		break;
	case MATCH_SUCCESS:
		cout << "������ȷ�����ڵ�½..." << endl;
		break;
	case MATCH_FAILED:
		cout << "�������!!!" << endl;
		break;
	case LANDING_FAILED:
		cout << "ȡ����½..." << endl;
		break;
	case LANDING_SUCCESS:
		cout << "��½�ɹ�..." << endl;
		break;
	case OPEN_FILE_FAILED:
		cout << "���ļ�ʧ��..." << endl;
		break;
	case READ_FILE_FAILED:
		cout << "��ȡ�ļ�ʧ��..." << endl;
		break;
	case WRITE_FILE_FAILED:
		cout << "�����ļ�ʧ��..." << endl;
		break;
	
	default:break;
	}
	return false;
}
*/

FLAG PASSWORD::ReadFile()
{
	fstream file;
	file.open(PASSWORD_FileID, ios::in|ios::_Nocreate);
	
	if (!file.is_open())
	{
		cout << "���ļ�ʧ��..." << endl;
		return PASSWORD_OPEN_FILE_FAILED;
	}
	file.seekg(ios::beg);
	file >> m_sPassword;
	if (file.fail()) 
	{
		cout << "��ȡ�ļ�ʧ��..." << endl;
		return PASSWORD_READ_FILE_FAILED;
	}
	return PASSWORD_READ_FILE_SUCCESS;
}

FLAG PASSWORD::WriteFile()
{
	fstream file;
	file.open(PASSWORD_FileID, ios::out|ios::trunc);

	if (!file.is_open())
	{
		cout << "���ļ�ʧ��..." << endl;
		return PASSWORD_OPEN_FILE_FAILED;
	}
	file.seekp(ios::beg);
	file << m_sPassword;
	if (file.fail())
	{
		cout << "�����ļ�ʧ��..." << endl;
		return PASSWORD_WRITE_FILE_FAILED;
	}
	return PASSWORD_WRITE_FILE_SUCCESS;
}

PASSWORD::PASSWORD(const PASSWORD& rhs)
{

}
PASSWORD & PASSWORD::operator=(const PASSWORD & rhs)
{
	return *this;
}
