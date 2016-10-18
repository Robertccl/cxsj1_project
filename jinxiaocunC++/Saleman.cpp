#include "Saleman.h"

bool SALEMAN::operator==(SALEMAN & rhs)
{
	return ((address == rhs.address)
		//&& (number == rhs.number)
		&& (name == rhs.name)
		&& (birthDate == rhs.birthDate)
		&& (phone == rhs.phone)
		&& (employedDate == rhs.employedDate)
		&& (gender == rhs.gender));
}

void SALEMAN::Input(SALEMAN & temp, int mode)
{
	system("cls");
	cout << "����������Ա��Ϣ:" << endl;
	//cout << "����:";
	//cin >> temp.number;
	cout << "����:";
	cin >> temp.name;
	cout << "�Ա�:";
	cin >> temp.gender;
	cout << "��ϵ�绰:";
	cin >> temp.phone;
	cout << "��ϵ��ַ:";
	cin >> temp.address;
	cout << "����������:";
	cin >> temp.birthDate;
	cout << "��ְʱ��:";
	cin >> temp.employedDate;

	if (mode == SALEMAN_NEW)
	{

	}
}

void SALEMAN::ShowMenu()
{
	system("cls"); /*����*/
	cout << "\t\t ====================================" << endl;
	cout << "\t\t��             ��Ա����             ��" << endl;
	cout << "\t\t ====================================" << endl;
	cout << "\t\t   ��������������������������������" << endl;
	cout << "\t\t   �� 1. �����Ϣ    2. ��Ϣ��ѯ ��" << endl;
	cout << "\t\t   ��                            ��" << endl;
	cout << "\t\t   �� 3. �޸���Ϣ    4. ɾ����Ϣ ��" << endl;
	cout << "\t\t   ��                            ��" << endl;
	cout << "\t\t   �� 0. �����ϼ�                ��" << endl;
	cout << "\t\t   ��������������������������������" << endl;
}

void SALEMAN::ShowChooseMenu()
{
	cout << "��ѡ����Ҫ�޸���Ϣ�����:" << endl;
	cout //<< "1.����" << endl
		<< "1.����" << endl
		<< "2.�Ա�" << endl
		<< "3.��ϵ�绰" << endl
		<< "4.��ϵ��ַ" << endl
		<< "5.����������" << endl
		<< "6.��ְʱ��" << endl
		<< "7.�޸�����������Ϣ" << endl;
}

void SALEMAN::Change(SALEMAN & temp, int choose)
{
	string key;

	if (1 <= choose&&choose <= 6)
	{
		cout << "�������µ�����:";
		cin >> key;
	}
	switch (choose)
	{
	//case 1: temp.number = key; break;
	case SALEMAN_NAME: 
		temp.name = key;
		break;
	case SALEMAN_GENDER:
		temp.gender = key; 
		break;
	case SALEMAN_PHONE:
		temp.phone = key;
		break;
	case SALEMAN_ADDRESS:
		temp.address = key;
		break;
	case SALEMAN_BRITHDAY:
		temp.birthDate = key;
		break;
	case SALEMAN_EMPLOYED_DATE:
		temp.employedDate = key; 
		break;
	case SALEMAN_CHANGE_ALL:
		Input(temp, SALEMAN_OLD);
		break;

	default:break;
	}
}

void SALEMAN::ShowInformation(const SALEMAN & temp)
{
	cout << "����:" << temp.number << endl
		<< "����:" << temp.name << endl
		<< "�Ա�:" << temp.gender << endl
		<< "��ϵ�绰:" << temp.phone << endl
		<< "��ϵ��ַ:" << temp.address << endl
		<< "����������:" << temp.birthDate << endl
		<< "��ְʱ��:" << temp.employedDate << endl;
}

fstream SALEMAN::Open(ios_base::openmode mode)
{
	fstream file;
	file.open(SALEMAN_FileID, mode);
	return file;
}


