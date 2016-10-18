#include "Product.h"

bool PRODUCT::operator==( PRODUCT & rhs)
{
	return ((producer == rhs.producer)
		//&& (number == rhs.number)
		&& (name == rhs.name)
		&& (stockDate == rhs.stockDate)
		&& (unitPrice == rhs.unitPrice)
		&& (price == rhs.price)
		&& (totalNumber == rhs.totalNumber));
}

void PRODUCT::Input(PRODUCT & temp, int mode)
{
	system("cls");
	cout << "������Ʒ��Ϣ:" << endl;
	cout << "����:";
	cin >> temp.name;
	//cout << "����:";
	//cin >> temp.code;
	cout << "����:";
	cin >> temp.unitPrice;
	cout << "�ۼ�:";
	cin >> temp.price;
	cout << "����:";
	cin >> temp.totalNumber;
	cout << "���ʱ��:";
	cin >> temp.stockDate;
	cout << "����:";
	cin >> temp.producer;

	if (mode == PRODUCT_NEW)
	{

	}
}

void PRODUCT::ShowMenu()
{
	system("cls"); /*����*/
	cout << "\t\t ====================================" << endl;
	cout << "\t\t��             ��Ʒ����             ��" << endl;
	cout << "\t\t ====================================" << endl;
	cout << "\t\t   ��������������������������������" << endl;
	cout << "\t\t   �� 1. �����Ϣ    2. ��Ϣ��ѯ ��" << endl;
	cout << "\t\t   ��                            ��" << endl;
	cout << "\t\t   �� 3. �޸���Ϣ    4. ɾ����Ϣ ��" << endl;
	cout << "\t\t   ��                            ��" << endl;
	cout << "\t\t   �� 0. �����ϼ�                ��" << endl;
	cout << "\t\t   ��������������������������������" << endl;
}

void PRODUCT::ShowChooseMenu()
{
	cout << "��ѡ����Ҫ�޸���Ϣ�����:" << endl;
	cout << "1.����" << endl
		//<< "2.����" << endl
		<< "2.����" << endl
		<< "3.�ۼ�" << endl
		<< "4.����" << endl
		<< "5.���ʱ��" << endl
		<< "6.����" << endl
		<< "7.�޸�����������Ϣ" << endl;
}

void PRODUCT::Change(PRODUCT & temp, int choose)
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
	case PRODUCT_NAME:
		temp.name = key;
		break;
	case PRODUCT_UNIT_PRICE:
		temp.unitPrice = atof(key.c_str());
		break;
	case PRODUCT_PRICE:
		temp.price = atof(key.c_str());
		break;
	case PRODUCT_TOTAL_NUMBER:
		temp.totalNumber = (unsigned int)atoi(key.c_str());
		break;
	case PRODUCT_STOCK_DATE:
		temp.stockDate = key;
		break;
	case PRODUCT_PRODUCERNAME:
		temp.producer = key;
		break;
	case PRODUCT_CHANGE_ALL:
		Input(temp, PRODUCT_OLD);
		break;

	default:break;
	}
}

void PRODUCT::ShowInformation(const PRODUCT & temp)
{
	cout << "����:" << temp.name << endl
		//<< "����:" << temp.code << endl
		<< "����:" << temp.unitPrice << endl
		<< "�ۼ�:" << temp.price << endl
		<< "����:" << temp.totalNumber << endl
		<< "����:" << temp.producer << endl
		<< "���ʱ��:" << temp.stockDate << endl;
}

fstream PRODUCT::Open(ios_base::openmode mode)
{
	fstream file;
	file.open(PRODUCT_FileID, mode);
	return file;
}
