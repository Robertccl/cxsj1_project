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
	cout << "输入商品信息:" << endl;
	cout << "名称:";
	cin >> temp.name;
	//cout << "编码:";
	//cin >> temp.code;
	cout << "进价:";
	cin >> temp.unitPrice;
	cout << "售价:";
	cin >> temp.price;
	cout << "总数:";
	cin >> temp.totalNumber;
	cout << "入库时间:";
	cin >> temp.stockDate;
	cout << "产商:";
	cin >> temp.producer;

	if (mode == PRODUCT_NEW)
	{

	}
}

void PRODUCT::ShowMenu()
{
	system("cls"); /*清屏*/
	cout << "\t\t ====================================" << endl;
	cout << "\t\t│             产品管理             │" << endl;
	cout << "\t\t ====================================" << endl;
	cout << "\t\t   ┌──────────────┐" << endl;
	cout << "\t\t   │ 1. 添加信息    2. 信息查询 │" << endl;
	cout << "\t\t   │                            │" << endl;
	cout << "\t\t   │ 3. 修改信息    4. 删除信息 │" << endl;
	cout << "\t\t   │                            │" << endl;
	cout << "\t\t   │ 0. 返回上级                │" << endl;
	cout << "\t\t   └──────────────┘" << endl;
}

void PRODUCT::ShowChooseMenu()
{
	cout << "请选择需要修改信息的类别:" << endl;
	cout << "1.名称" << endl
		//<< "2.编码" << endl
		<< "2.进价" << endl
		<< "3.售价" << endl
		<< "4.总数" << endl
		<< "5.入库时间" << endl
		<< "6.产商" << endl
		<< "7.修改以上所有信息" << endl;
}

void PRODUCT::Change(PRODUCT & temp, int choose)
{
	string key;

	if (1 <= choose&&choose <= 6)
	{
		cout << "请输入新的内容:";
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
	cout << "名称:" << temp.name << endl
		//<< "编码:" << temp.code << endl
		<< "进价:" << temp.unitPrice << endl
		<< "售价:" << temp.price << endl
		<< "总数:" << temp.totalNumber << endl
		<< "产商:" << temp.producer << endl
		<< "入库时间:" << temp.stockDate << endl;
}

fstream PRODUCT::Open(ios_base::openmode mode)
{
	fstream file;
	file.open(PRODUCT_FileID, mode);
	return file;
}
