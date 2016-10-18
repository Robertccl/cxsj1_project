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
	cout << "输入销售信息:" << endl;
	//cout << "销售记录流水号:";
	//cin >> temp.number;
	cout << "产商编号:";
	cin >> temp.producerNumber;
	cout << "商品编号:";
	cin >> temp.productNumber;
	cout << "进价:";
	cin >> temp.unitPrice;
	cout << "售价:";
	cin >> temp.price;
	cout << "此商品的销售总量:";
	cin >> temp.amount;
	cout << "销售员代码:";
	cin >> temp.salemanNumber;
	cout << "销售员名字:";
	cin >> temp.saleman;
	cout << "销售时间:";
	cin >> temp.salesDate;
	cout << "顾客代码:";
	cin >> temp.customerNumber;
	
	cout << "销售备注:";
	cin >> temp.notes;
	if (mode == MARKETING_NEW)
	{

	}
}

void MARKETING::ShowMenu()
{
	system("cls"); /*清屏*/
	cout << "\t\t ====================================" << endl;
	cout << "\t\t│             销售管理             │" << endl;
	cout << "\t\t ====================================" << endl;
	cout << "\t\t   ┌──────────────┐" << endl;
	cout << "\t\t   │ 1. 添加信息    2. 信息查询 │" << endl;
	cout << "\t\t   │                            │" << endl;
	cout << "\t\t   │ 3. 修改信息    4. 删除信息 │" << endl;
	cout << "\t\t   │                            │" << endl;
	cout << "\t\t   │ 0. 返回上级                │" << endl;
	cout << "\t\t   └──────────────┘" << endl;
}

void MARKETING::ShowChooseMenu()
{
	cout << "请选择需要修改信息的类别:" << endl;
	cout << "1.产商编号" << endl
		<< "2.商品编号" << endl
		<< "3.进价" << endl
		<< "4.售价" << endl
		<< "5.此商品的销售总量" << endl
		<< "6.销售员代码" << endl
		<< "7.销售员名字" << endl
		<< "8.销售时间" << endl
		<< "9.顾客代码" << endl
		<< "10.销售备注" << endl
		<< "11.修改以上所有信息" << endl;
}

void MARKETING::Change(MARKETING & temp, int choose)
{
	string key;

	if (1 <= choose&&choose <= 10)
	{
		cout << "请输入新的内容:";
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
	cout << "销售记录流水号:" << temp.number << endl
		<< "销售记录名字:" << temp.name << endl
		<< "产商编号:" << temp.producerNumber << endl
		<< "商品编号:" << temp.productNumber << endl
		<< "进价:" << temp.unitPrice << endl
		<< "售价:" << temp.price << endl
		<< "此商品的销售总量:" << temp.amount << endl
		<< "销售员代码:" << temp.salemanNumber << endl
		<< "销售员名字:" << temp.saleman << endl
		<< "销售时间:" << temp.salesDate << endl
		<< "顾客代码:" << temp.customerNumber << endl
		<< "销售备注:" << temp.notes << endl;
}

fstream MARKETING::Open(ios_base::openmode mode)
{
	fstream file;
	file.open(MARKETING_FileID,mode);
	return file;
}
