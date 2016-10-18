#include "Password.h"

PASSWORD::PASSWORD()
{
	FLAG flag;
	flag = ReadFile();
	if (PASSWORD_READ_FILE_FAILED == flag
		|| PASSWORD_OPEN_FILE_FAILED == flag)
		exit(0);
}

PASSWORD::~PASSWORD()
{
}

void PASSWORD::ShowMenu()
{
	system("cls"); /*清屏*/
	cout << "\t\t ======================================" << endl;
	cout << "\t\t│            密码管理系统            │" << endl;
	cout << "\t\t ======================================" << endl;
	cout << "\t\t   ┌───────────────┐" << endl;
	cout << "\t\t   │ 1.重置密码     2.登陆系统    │" << endl;
	cout << "\t\t   │                              │" << endl;
	cout << "\t\t   │ 3.退出系统                   │" << endl;
	cout << "\t\t   └───────────────┘" << endl;
}

FLAG PASSWORD::Input(string &newPassword)
{
	//Prompt(INPUT);
	cin >> newPassword;
	if (cin.fail())
	{
		cout << "请输入密码(取消登陆:x):	";
		return PASSWORD_INPUT_FAILED;
	}
	if (newPassword == "x" || newPassword == "X")
	{
		cout << "密码输入失败!!!" << endl;
		return PASSWORD_INPUT_FAILED;
	}
	//检查密码是否安全
	return PASSWORD_INPUT_SUCCESS;
}

FLAG PASSWORD::ReSet()
{
	FLAG flag;
	string oldPassword;
	
	do
	{
		cout << "请输入旧密码(取消登陆:x):	";
		if (PASSWORD_INPUT_FAILED == Input(oldPassword))
		{
			cout << "密码重置失败!!!" << endl;
			return PASSWORD_RESET_FAILED;
		}
	} while (PASSWORD_MATCH_FAILED == Match(oldPassword));

	string newPassword;
	string newPassword_2;

	do
	{
		cout << "请输入新密码(取消登陆:x):	";
		if (PASSWORD_INPUT_FAILED == Input(newPassword))
		{
			cout << "密码重置失败!!!" << endl;
			return PASSWORD_RESET_FAILED;
		}

		cout << "请确认新密码(取消登陆:x):	";
		if (PASSWORD_INPUT_FAILED == Input(newPassword_2))
		{
			cout << "密码重置失败!!!" << endl;
			return PASSWORD_RESET_FAILED;
		}
		
	} while (newPassword != newPassword_2);

	//m_sPassword = Encrypt(newPassword);

	flag = WriteFile();
	if (PASSWORD_WRITE_FILE_FAILED == flag
		|| PASSWORD_OPEN_FILE_FAILED == flag)
		exit(0);

	cout << "密码重置成功!!!" << endl;
	return PASSWORD_RESET_SUCCESS;
}

FLAG PASSWORD::Landing()
{
	string password;

	do
	{
		cout << "请输入密码(取消登陆:x):	";
		if (PASSWORD_INPUT_FAILED == Input(password))
		{
			return PASSWORD_INPUT_FAILED;
		}
	} while (PASSWORD_MATCH_FAILED == Match(password));

	cout << "登陆成功..." << endl;
	return PASSWORD_LANDING_SUCCESS;
}

FLAG PASSWORD::Run()
{
	
	char choose;
	ShowMenu();
	cin.clear();
	cin.sync();
	cin >> choose;
	choose -= '0';
	switch ((int)choose)
	{
	case PASSWORD_RESET:
		ReSet();
		break;
	case PASSWORD_LANDING:
		Landing();
		break;
	case PASSWORD_LOG_OUT:
		cout << "取消登陆..." << endl;
		return PASSWORD_LANDING_FAILED;
	default:break;
	}
	return PASSWORD_SUCCESS;
}

FLAG PASSWORD::Match(const string password)
{
	//password = Encrypt(password);
	if (m_sPassword == password)
	{
		cout << "密码正确，正在登陆..." << endl;
		return PASSWORD_MATCH_SUCCESS;
	}
	cout << "密码错误!!!" << endl;
	return PASSWORD_MATCH_FAILED;
}

/*

bool PASSWORD::Prompt(int choose)
{
	switch (choose)
	{
	case INPUT_PASSWORD:
		cout << "请输入密码(取消登陆:x):	";
		break;
	case INPUT_NEW_PASSWORD:
		cout << "请输入新密码(取消登陆:x):	";
		break;
	case INPUT_OLD_PASSWORD:
		cout << "请输入旧密码(取消登陆:x):	";
		break;
	case INPUT_NEW_PASSWORD_AGAIN:
		cout << "请确认新密码(取消登陆:x):	";
		break;
	case INPUT_FAILED:
		cout << "密码输入失败!!!" << endl;
		break;
	case RESET_SUCCESS:
		cout << "密码重置成功!!!" << endl;
		break;
	case RESET_FAILED:
		cout << "密码重置失败!!!" << endl;
		break;
	case MATCH_SUCCESS:
		cout << "密码正确，正在登陆..." << endl;
		break;
	case MATCH_FAILED:
		cout << "密码错误!!!" << endl;
		break;
	case LANDING_FAILED:
		cout << "取消登陆..." << endl;
		break;
	case LANDING_SUCCESS:
		cout << "登陆成功..." << endl;
		break;
	case OPEN_FILE_FAILED:
		cout << "打开文件失败..." << endl;
		break;
	case READ_FILE_FAILED:
		cout << "读取文件失败..." << endl;
		break;
	case WRITE_FILE_FAILED:
		cout << "保存文件失败..." << endl;
		break;
	
	default:break;
	}
	return false;
}
*/

FLAG PASSWORD::ReadFile()
{
	fstream file;
	file.open(PASSWORD_FileID, ios::in|ios::_Nocreate);
	
	if (!file.is_open())
	{
		cout << "打开文件失败..." << endl;
		return PASSWORD_OPEN_FILE_FAILED;
	}
	file.seekg(ios::beg);
	file >> m_sPassword;
	if (file.fail()) 
	{
		cout << "读取文件失败..." << endl;
		return PASSWORD_READ_FILE_FAILED;
	}
	return PASSWORD_READ_FILE_SUCCESS;
}

FLAG PASSWORD::WriteFile()
{
	fstream file;
	file.open(PASSWORD_FileID, ios::out|ios::trunc);

	if (!file.is_open())
	{
		cout << "打开文件失败..." << endl;
		return PASSWORD_OPEN_FILE_FAILED;
	}
	file.seekp(ios::beg);
	file << m_sPassword;
	if (file.fail())
	{
		cout << "保存文件失败..." << endl;
		return PASSWORD_WRITE_FILE_FAILED;
	}
	return PASSWORD_WRITE_FILE_SUCCESS;
}

PASSWORD::PASSWORD(const PASSWORD& rhs)
{

}
PASSWORD & PASSWORD::operator=(const PASSWORD & rhs)
{
	return *this;
}
