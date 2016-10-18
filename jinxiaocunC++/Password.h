#pragma once

#include <iostream>
#include <fstream>
#include <string>
#include "PasswordMARK.h"
using namespace std;

typedef char FLAG;

const string PASSWORD_FileID = "Password.txt";


class PASSWORD
{
	//const static string FileID;
public:
	PASSWORD();
	~PASSWORD();
		
	FLAG Run();
	
private:
	string m_sPassword;
	
	PASSWORD(const PASSWORD& rhs);
	PASSWORD& operator=(const PASSWORD& rhs);

	void ShowMenu();
	FLAG Input(string & newPassword);
	FLAG ReSet();
	FLAG Landing();
	FLAG Match(const string password);
	//bool Prompt(int choose);
	FLAG ReadFile();
	FLAG WriteFile();
};

