#include "Producer.h"

bool PRODUCER::operator==(PRODUCER & rhs)
{
	return ((address == rhs.address)
		//&& (number == rhs.number)
		&& (name == rhs.name)
		&& (phone == rhs.phone));
}

void PRODUCER::Input(PRODUCER & temp, int mode)
{
	system("cls");
	cout << "�����������Ϣ:" << endl;
	cout << "����:";
	cin >> temp.name;
	cout << "��ϵ�绰:";
	cin >> temp.phone;
	cout << "��ϵ��ַ:";
	cin >> temp.address;

	if (mode == PRODUCER_NEW)
	{

	}
}

void PRODUCER::ShowMenu()
{
	system("cls"); /*����*/
	cout << "\t\t ====================================" << endl;
	cout << "\t\t��             �����̹���           ��" << endl;
	cout << "\t\t ====================================" << endl;
	cout << "\t\t   ��������������������������������" << endl;
	cout << "\t\t   �� 1. �����Ϣ    2. ��Ϣ��ѯ ��" << endl;
	cout << "\t\t   ��                            ��" << endl;
	cout << "\t\t   �� 3. �޸���Ϣ    4. ɾ����Ϣ ��" << endl;
	cout << "\t\t   ��                            ��" << endl;
	cout << "\t\t   �� 0. �����ϼ�                ��" << endl;
	cout << "\t\t   ��������������������������������" << endl;
}

void PRODUCER::ShowChooseMenu()
{
	cout << "��ѡ����Ҫ�޸���Ϣ�����:" << endl;
	cout << "1.����" << endl
		<< "2.��ϵ�绰" << endl
		<< "3.��ϵ��ַ" << endl
		<< "4.�޸�����������Ϣ" << endl;
}

void PRODUCER::Change(PRODUCER & temp, int choose)
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
	case PRODUCER_NAME:
		temp.name = key;
		break;
	case PRODUCER_PHONE:
		temp.phone = key;
		break;
	case PRODUCER_ADDRESS:
		temp.address = key;
		break;
	case PRODUCER_CHANGE_ALL:
		Input(temp, PRODUCER_OLD);
		break;

	default:break;
	}
}

void PRODUCER::ShowInformation(const PRODUCER & temp)
{
	cout << "����:" << temp.name << endl
		<< "���:" << temp.number << endl
		<< "��ϵ�绰:" << temp.phone << endl
		<< "��ϵ��ַ:" << temp.address << endl;
}

fstream PRODUCER::Open(ios_base::openmode mode)
{
	fstream file;
	file.open(PRODUCER_FileID,mode);
	return file;
}
