#include"My_fstream.h"


fstream & operator<<(fstream & file, SALEMAN & obj)
{
	file << obj.address
		<< obj.birthDate
		<< obj.employedDate
		<< obj.gender
		<< obj.name
		<< obj.number
		<< obj.phone;
	return file;
}

fstream & operator<<(fstream & file, PRODUCER & obj)
{
	file << obj.address
		<< obj.name
		<< obj.number
		<< obj.phone;
	return file;
}

fstream & operator<<(fstream & file, PRODUCT & obj)
{
	file << obj.name
		<< obj.number
		<< obj.price
		<< obj.producer;
	return file;
}

fstream & operator<<(fstream & file, MARKETING & obj)
{
	
	file << obj.amount
		<< obj.customerNumber
		<< obj.name
		<< obj.notes
		<< obj.number
		<< obj.unitPrice
		<< obj.price
		<< obj.producerNumber
		<< obj.productNumber
		<< obj.saleman
		<< obj.salemanNumber
		<< obj.salesDate;
	return file;
}

fstream & operator<<(fstream & file, CUSTOMER & obj)
{
	file << obj.address
		<< obj.name
		<< obj.number
		<< obj.phone;
	return file;
}

fstream & operator>>(fstream & file,  SALEMAN & obj)
{
	file >> obj.address
		>> obj.birthDate
		>> obj.employedDate
		>> obj.gender
		>> obj.name
		>> obj.number
		>> obj.phone;
	return file;
}

fstream & operator>>(fstream & file,  PRODUCER & obj)
{
	file >> obj.address
		>> obj.name
		>> obj.number
		>> obj.phone;
	return file;
}

fstream & operator>>(fstream & file,  PRODUCT & obj)
{
	file >> obj.name
		>> obj.number
		>> obj.price
		>> obj.producer;
	return file;
}

fstream & operator>>(fstream & file,  MARKETING & obj)
{

	file >> obj.amount
		>> obj.customerNumber
		>> obj.name
		>> obj.notes
		>> obj.number
		>> obj.unitPrice
		>> obj.price
		>> obj.producerNumber
		>> obj.productNumber
		>> obj.saleman
		>> obj.salemanNumber
		>> obj.salesDate;
	return file;
}

fstream & operator>>(fstream & file,  CUSTOMER & obj)
{
	file >> obj.address
		>> obj.name
		>> obj.number
		>> obj.phone;
	return file;
}
