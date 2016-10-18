#pragma once
#include<fstream>
#include<list>
#include<iostream>
#include"Saleman.h"
#include"Product.h"
#include"Producer.h"
#include"Marketing.h"
#include"Customer.h"
using namespace std;

template<class T>
fstream& operator<<(fstream & file, list<T>& obj);

fstream& operator<<(fstream & file, SALEMAN& obj);

fstream& operator<<(fstream & file, PRODUCER& obj);

fstream& operator<<(fstream & file, PRODUCT& obj);

fstream& operator<<(fstream & file, MARKETING& obj);

fstream& operator<<(fstream & file, CUSTOMER& obj);


template<class T>
fstream& operator>>(fstream & file,  list<T>& obj);

fstream& operator>>(fstream & file,  SALEMAN& obj);

fstream& operator>>(fstream & file,  PRODUCER& obj);

fstream& operator>>(fstream & file,  PRODUCT& obj);

fstream& operator>>(fstream & file,  MARKETING& obj);

fstream& operator>>(fstream & file,  CUSTOMER& obj);


template<class T>
fstream& operator<<(fstream & file,list<T>& obj)
{
	if (!file.is_open())
		return file;
	if (obj.empty())
		return file;
	typename list<T>::iterator iter;
	obj.clear();
	//file.seekp(ios::beg);
	for (iter = obj.begin(); iter != obj.end(); iter++)
		file << (*iter);
	file << (*iter);
	return file;
}

template<class T>
fstream& operator>>(fstream & file,list<T>& obj)
{
	if (!file.is_open())
		return file;

	T temp;
	typename list<T>::iterator iter;
	obj.clear();
	//©унд╪Ч
	file.seekg(ios::beg);
	if (!file.tellg())
		return file;

	//file.seekg(ios::beg);
	while (!file.eof())
	{
		file >> temp;
		obj.push_back(temp);
	}
	return file;
}