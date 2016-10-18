#pragma once

#include <iostream>
#include <string>
#include<fstream>
#include "PRODUCER_MARK.h"
using namespace std;

//typedef char FLAG;

const string PRODUCER_FileID = "Producer.txt";

struct PRODUCER
{
	//const static string FileID;
	string address;
	string number;
	string name;
	string phone;

	bool operator==(PRODUCER& rhs);
	void Input(PRODUCER &temp, int mode = PRODUCER_NEW);
	void ShowMenu();
	void ShowChooseMenu();
	void Change(PRODUCER &temp, int choose);
	void ShowInformation(const PRODUCER& temp);
	fstream Open(ios_base::openmode mode);
	
};
