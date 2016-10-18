#include "Customer.h"

bool CUSTOMER::operator==(CUSTOMER & rhs)
{
	return ((address == rhs.address)
		//&& (number == rhs.number)
		&& (name == rhs.name)
		&& (phone == rhs.phone));
}

void CUSTOMER::Input(CUSTOMER & temp, int mode)
{
	system("cls");
	cout << "����˿���Ϣ:" << endl;
	cout << "����:";
	cin >> temp.name;
	cout << "��ϵ�绰:";
	cin >> temp.phone;
	cout << "��ϵ��ַ:";
	cin >> temp.address;

	if (mode == CUSTOMER_NEW)
	{
		 
	}
}

void CUSTOMER::ShowMenu()
{
	system("cls"); /*����*/
	cout << "\t\t ====================================" << endl;
	cout << "\t\t��             �˿͹���             ��" << endl;
	cout << "\t\t ====================================" << endl;
	cout << "\t\t   ��������������������������������" << endl;
	cout << "\t\t   �� 1. �����Ϣ    2. ��Ϣ��ѯ ��" << endl;
	cout << "\t\t   ��                            ��" << endl;
	cout << "\t\t   �� 3. �޸���Ϣ    4. ɾ����Ϣ ��" << endl;
	cout << "\t\t   ��                            ��" << endl;
	cout << "\t\t   �� 0. �����ϼ�                ��" << endl;
	cout << "\t\t   ��������������������������������" << endl;
}

void CUSTOMER::ShowChooseMenu()
{
	cout << "��ѡ����Ҫ�޸���Ϣ�����:" << endl;
	cout << "1.����" << endl
		<< "2.��ϵ�绰" << endl
		<< "3.��ϵ��ַ" << endl
		<< "4.�޸�����������Ϣ" << endl;
}

void CUSTOMER::Change(CUSTOMER & temp, int choose)
{
	string key;

	if (1 <= choose&&choose <= 3)
	{
		cout << "�������µ�����:";
		cin >> key;
	}
	switch (choose)
	{
		//case 1: temp.number = key; break;
	case CUSTOMER_NAME:
		temp.name = key;
		break;
	case CUSTOMER_PHONE:
		temp.phone = key;
		break;
	case CUSTOMER_ADDRESS:
		temp.address = key;
		break;
	case CUSTOMER_CHANGE_ALL:
		Input(temp, CUSTOMER_OLD);
		break;

	default:break;
	}
}

void CUSTOMER::ShowInformation(const CUSTOMER & temp)
{
	cout << "����:" << temp.name << endl
		<< "��ϵ�绰:" << temp.phone << endl
		<< "��ϵ��ַ:" << temp.address << endl;
}

fstream CUSTOMER::Open(ios_base::openmode mode)
{
	fstream file;
	file.open(CUSTOMER_FileID,mode);
	return file;
}
