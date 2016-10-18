#include "Marketing.h"

bool MARKETING::operator==(MARKETING & rhs)
{
	return ((salemanNumber == rhs.salemanNumber)
		//&& (number == rhs.number)
		&& (name == rhs.name)
		&& (saleman == rhs.saleman)
		&& (customerNumber == rhs.customerNumber)
		&& (producerNumber == rhs.producerNumber)
		&& (productNumber == rhs.productNumber)
		&& (salesDate == rhs.salesDate)
		&& (amount == rhs.amount)
		&& (unitPrice == rhs.unitPrice)
		&& (price == rhs.price)
		&& (notes == rhs.notes));
}

void MARKETING::Input(MARKETING & temp, int mode)
{
	system("cls");
	cout << "����������Ϣ:" << endl;
	//cout << "���ۼ�¼��ˮ��:";
	//cin >> temp.number;
	cout << "���̱��:";
	cin >> temp.producerNumber;
	cout << "��Ʒ���:";
	cin >> temp.productNumber;
	cout << "����:";
	cin >> temp.unitPrice;
	cout << "�ۼ�:";
	cin >> temp.price;
	cout << "����Ʒ����������:";
	cin >> temp.amount;
	cout << "����Ա����:";
	cin >> temp.salemanNumber;
	cout << "����Ա����:";
	cin >> temp.saleman;
	cout << "����ʱ��:";
	cin >> temp.salesDate;
	cout << "�˿ʹ���:";
	cin >> temp.customerNumber;
	
	cout << "���۱�ע:";
	cin >> temp.notes;
	if (mode == MARKETING_NEW)
	{

	}
}

void MARKETING::ShowMenu()
{
	system("cls"); /*����*/
	cout << "\t\t ====================================" << endl;
	cout << "\t\t��             ���۹���             ��" << endl;
	cout << "\t\t ====================================" << endl;
	cout << "\t\t   ��������������������������������" << endl;
	cout << "\t\t   �� 1. �����Ϣ    2. ��Ϣ��ѯ ��" << endl;
	cout << "\t\t   ��                            ��" << endl;
	cout << "\t\t   �� 3. �޸���Ϣ    4. ɾ����Ϣ ��" << endl;
	cout << "\t\t   ��                            ��" << endl;
	cout << "\t\t   �� 0. �����ϼ�                ��" << endl;
	cout << "\t\t   ��������������������������������" << endl;
}

void MARKETING::ShowChooseMenu()
{
	cout << "��ѡ����Ҫ�޸���Ϣ�����:" << endl;
	cout << "1.���̱��" << endl
		<< "2.��Ʒ���" << endl
		<< "3.����" << endl
		<< "4.�ۼ�" << endl
		<< "5.����Ʒ����������" << endl
		<< "6.����Ա����" << endl
		<< "7.����Ա����" << endl
		<< "8.����ʱ��" << endl
		<< "9.�˿ʹ���" << endl
		<< "10.���۱�ע" << endl
		<< "11.�޸�����������Ϣ" << endl;
}

void MARKETING::Change(MARKETING & temp, int choose)
{
	string key;

	if (1 <= choose&&choose <= 10)
	{
		cout << "�������µ�����:";
		cin >> key;
	}
	switch (choose)
	{
		//case 1: temp.number = key; break;
	case MARKETING_PRODUCER_NUMBER:
		temp.producerNumber = key;
		break;
	case MARKETING_PRODUCT_NUMBER:
		temp.productNumber = key;
		break;
	case MARKETING_UNIT_PRICE:
		temp.unitPrice = atof(key.c_str());
		break;
	case MARKETING_PRICE:
		temp.price = atof(key.c_str());
		break;
	case MARKETING_AMOUNT:
		temp.amount = (unsigned int)atoi(key.c_str());
		break;
	case MARKETING_SALEMAN_NUMBER:
		temp.salemanNumber = key;
		break;
	case MARKETING_SALESMAN:
		temp.saleman = key;
		break;
	case MARKETING_SALES_DATE:
		temp.salesDate = key;
		break;
	case MARKETING_NOTES:
		temp.notes = key;
		break;
	case MARKETING_CHANGE_ALL:
		Input(temp, MARKETING_OLD);
		break;

	default:break;
	}
}

void MARKETING::ShowInformation(const MARKETING & temp)
{
	cout << "���ۼ�¼��ˮ��:" << temp.number << endl
		<< "���ۼ�¼����:" << temp.name << endl
		<< "���̱��:" << temp.producerNumber << endl
		<< "��Ʒ���:" << temp.productNumber << endl
		<< "����:" << temp.unitPrice << endl
		<< "�ۼ�:" << temp.price << endl
		<< "����Ʒ����������:" << temp.amount << endl
		<< "����Ա����:" << temp.salemanNumber << endl
		<< "����Ա����:" << temp.saleman << endl
		<< "����ʱ��:" << temp.salesDate << endl
		<< "�˿ʹ���:" << temp.customerNumber << endl
		<< "���۱�ע:" << temp.notes << endl;
}

fstream MARKETING::Open(ios_base::openmode mode)
{
	fstream file;
	file.open(MARKETING_FileID,mode);
	return file;
}
