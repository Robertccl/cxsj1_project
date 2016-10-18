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
	cout << "输入销售人员信息:" << endl;
	//cout << "代号:";
	//cin >> temp.number;
	cout << "姓名:";
	cin >> temp.name;
	cout << "性别:";
	cin >> temp.gender;
	cout << "联系电话:";
	cin >> temp.phone;
	cout << "联系地址:";
	cin >> temp.address;
	cout << "出生年月日:";
	cin >> temp.birthDate;
	cout << "入职时间:";
	cin >> temp.employedDate;

	if (mode == SALEMAN_NEW)
	{

	}
}

void SALEMAN::ShowMenu()
{
	system("cls"); /*清屏*/
	cout << "\t\t ====================================" << endl;
	cout << "\t\t│             人员管理             │" << endl;
	cout << "\t\t ====================================" << endl;
	cout << "\t\t   ┌──────────────┐" << endl;
	cout << "\t\t   │ 1. 添加信息    2. 信息查询 │" << endl;
	cout << "\t\t   │                            │" << endl;
	cout << "\t\t   │ 3. 修改信息    4. 删除信息 │" << endl;
	cout << "\t\t   │                            │" << endl;
	cout << "\t\t   │ 0. 返回上级                │" << endl;
	cout << "\t\t   └──────────────┘" << endl;
}

void SALEMAN::ShowChooseMenu()
{
	cout << "请选择需要修改信息的类别:" << endl;
	cout //<< "1.代号" << endl
		<< "1.姓名" << endl
		<< "2.性别" << endl
		<< "3.联系电话" << endl
		<< "4.联系地址" << endl
		<< "5.出生年月日" << endl
		<< "6.入职时间" << endl
		<< "7.修改以上所有信息" << endl;
}

void SALEMAN::Change(SALEMAN & temp, int choose)
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
	cout << "代号:" << temp.number << endl
		<< "姓名:" << temp.name << endl
		<< "性别:" << temp.gender << endl
		<< "联系电话:" << temp.phone << endl
		<< "联系地址:" << temp.address << endl
		<< "出生年月日:" << temp.birthDate << endl
		<< "入职时间:" << temp.employedDate << endl;
}

fstream SALEMAN::Open(ios_base::openmode mode)
{
	fstream file;
	file.open(SALEMAN_FileID, mode);
	return file;
}


