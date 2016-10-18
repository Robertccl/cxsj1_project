#pragma once

#include <iostream>
#include <string>
#include <fstream>
#include "MARKETING_MARK.h"
using namespace std;

//typedef char FLAG;
const string MARKETING_FileID = "Marketing.txt";

struct MARKETING
{
	//const static string FileID;
	string number;
	string name;
	string salemanNumber;
	string saleman;
	string customerNumber;
	string producerNumber;
	string productNumber;
	string salesDate;
	unsigned int amount;
	float unitPrice;
	float price;
	string notes;

	bool operator==(MARKETING& rhs);
	void Input(MARKETING &temp, int mode = MARKETING_NEW);
	void ShowMenu();
	void ShowChooseMenu();
	void Change(MARKETING &temp, int choose);
	void ShowInformation(const MARKETING& temp);
	fstream Open(ios_base::openmode mode);
	
};

