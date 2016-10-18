#pragma once

#include <iostream>
#include <string>
#include<fstream>
#include "CUSTOMER_MARK.h"
using namespace std;

//typedef char FLAG;
const string CUSTOMER_FileID = "Customer.txt";

struct CUSTOMER
{
	//const static string FileID;
	string address;
	string number;
	string name;
	string phone;

	bool operator==(CUSTOMER& rhs);
	void Input(CUSTOMER &temp, int mode = CUSTOMER_NEW);
	void ShowMenu();
	void ShowChooseMenu();
	void Change(CUSTOMER &temp, int choose);
	void ShowInformation(const CUSTOMER& temp);
	fstream Open(ios_base::openmode mode);

};

