#pragma once

#include <iostream>
#include <string>
#include<fstream>
#include "SALEMAN_MARK.h"
using namespace std;

//typedef char FLAG;
const string SALEMAN_FileID = "Saleman.txt";

struct SALEMAN
{
	//const static string FileID;
	string address;
	string number;
	string name;
	string birthDate;
	string phone;
	string employedDate;
	string gender;
	 
	bool operator==(SALEMAN& rhs);
	void Input(SALEMAN &temp,int mode= SALEMAN_NEW);
	void ShowMenu();
	void ShowChooseMenu();
	void Change(SALEMAN &temp, int choose);
	void ShowInformation(const SALEMAN& temp);
	fstream Open(ios_base::openmode mode);
	
};

