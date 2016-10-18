#pragma once


#include <iostream>
#include <string>
#include<fstream>
#include "PRODUCT_MARK.h"
using namespace std;

//typedef char FLAG;
const string PRODUCT_FileID = "Product.txt";

struct PRODUCT
{
	//const static string FileID;
	string number;
	string name;
	string producer;
	string stockDate;
	float unitPrice;
	float price;
	unsigned int totalNumber;

	bool operator==(PRODUCT& rhs);
	void Input(PRODUCT &temp, int mode = PRODUCT_NEW);
	void ShowMenu();
	void ShowChooseMenu();
	void Change(PRODUCT &temp, int choose);
	void ShowInformation(const PRODUCT& temp);
	fstream Open(ios_base::openmode mode);
	
};

