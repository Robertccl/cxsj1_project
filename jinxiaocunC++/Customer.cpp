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
	cout << "输入顾客信息:" << endl;
	cout << "姓名:";
	cin >> temp.name;
	cout << "联系电话:";
	cin >> temp.phone;
	cout << "联系地址:";
	cin >> temp.address;

	if (mode == CUSTOMER_NEW)
	{
		 
	}
}

void CUSTOMER::ShowMenu()
{
	system("cls"); /*清屏*/
	cout << "\t\t ====================================" << endl;
	cout << "\t\t│             顾客管理             │" << endl;
	cout << "\t\t ====================================" << endl;
	cout << "\t\t   ┌──────────────┐" << endl;
	cout << "\t\t   │ 1. 添加信息    2. 信息查询 │" << endl;
	cout << "\t\t   │                            │" << endl;
	cout << "\t\t   │ 3. 修改信息    4. 删除信息 │" << endl;
	cout << "\t\t   │                            │" << endl;
	cout << "\t\t   │ 0. 返回上级                │" << endl;
	cout << "\t\t   └──────────────┘" << endl;
}

void CUSTOMER::ShowChooseMenu()
{
	cout << "请选择需要修改信息的类别:" << endl;
	cout << "1.姓名" << endl
		<< "2.联系电话" << endl
		<< "3.联系地址" << endl
		<< "4.修改以上所有信息" << endl;
}

void CUSTOMER::Change(CUSTOMER & temp, int choose)
{
	string key;

	if (1 <= choose&&choose <= 3)
	{
		cout << "请输入新的内容:";
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
	cout << "姓名:" << temp.name << endl
		<< "联系电话:" << temp.phone << endl
		<< "联系地址:" << temp.address << endl;
}

fstream CUSTOMER::Open(ios_base::openmode mode)
{
	fstream file;
	file.open(CUSTOMER_FileID,mode);
	return file;
}
