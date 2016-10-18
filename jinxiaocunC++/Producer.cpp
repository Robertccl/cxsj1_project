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
	cout << "输入进货商信息:" << endl;
	cout << "姓名:";
	cin >> temp.name;
	cout << "联系电话:";
	cin >> temp.phone;
	cout << "联系地址:";
	cin >> temp.address;

	if (mode == PRODUCER_NEW)
	{

	}
}

void PRODUCER::ShowMenu()
{
	system("cls"); /*清屏*/
	cout << "\t\t ====================================" << endl;
	cout << "\t\t│             进货商管理           │" << endl;
	cout << "\t\t ====================================" << endl;
	cout << "\t\t   ┌──────────────┐" << endl;
	cout << "\t\t   │ 1. 添加信息    2. 信息查询 │" << endl;
	cout << "\t\t   │                            │" << endl;
	cout << "\t\t   │ 3. 修改信息    4. 删除信息 │" << endl;
	cout << "\t\t   │                            │" << endl;
	cout << "\t\t   │ 0. 返回上级                │" << endl;
	cout << "\t\t   └──────────────┘" << endl;
}

void PRODUCER::ShowChooseMenu()
{
	cout << "请选择需要修改信息的类别:" << endl;
	cout << "1.姓名" << endl
		<< "2.联系电话" << endl
		<< "3.联系地址" << endl
		<< "4.修改以上所有信息" << endl;
}

void PRODUCER::Change(PRODUCER & temp, int choose)
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
	cout << "姓名:" << temp.name << endl
		<< "编号:" << temp.number << endl
		<< "联系电话:" << temp.phone << endl
		<< "联系地址:" << temp.address << endl;
}

fstream PRODUCER::Open(ios_base::openmode mode)
{
	fstream file;
	file.open(PRODUCER_FileID,mode);
	return file;
}
