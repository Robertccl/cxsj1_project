// czl_002.cpp : �������̨Ӧ�ó������ڵ㡣
//
#include<iostream>

#include"Password.h"
#include"Saleman.h"
#include"Product.h"
#include"Producer.h"
#include"Marketing.h"
#include"Customer.h"
#include"SupermarketManagementInformationSystem.h"
using namespace std;

int Menu();

int main()
{
	SMIS<SALEMAN> saleman;
	SMIS<PRODUCT> product;
	SMIS<PRODUCER> producer;
	SMIS<MARKETING> marketing;
	SMIS<CUSTOMER> customer;
	PASSWORD password;
	//������� 

	if (SMIS_SUCCESS == password.Run())//������
	{
		//����
		while (true)
		{
			switch (Menu())
			{
			case 1:saleman.Run(); break;
			//case 2:product.Run(); break;
			//case 3:producer.Run(); break;
			//case 4:customer.Run(); break;
			//case 5:marketing.Run();	break;
			case 0:return 0;
			default:break;
			}
		}
	}
	
	
    return 0;
}

int Menu()
{
	int n;
	system("cls"); /*����*/
	printf("\t\t ====================================\n");
	printf("\t\t��         ������Ϣ����ϵͳ         ��\n");
	printf("\t\t ====================================\n");
	printf("\t\t  ����������������������������������\n");
	printf("\t\t  �� 1. ��Ա����     2. ��Ʒ����  ��\n");
	printf("\t\t  ��                              ��\n");
	printf("\t\t  �� 3. �����̹���   4. �˿͹���  ��\n");
	printf("\t\t  ��                              ��\n");
	printf("\t\t  �� 5. ���۹���     0. �˳�	  ��\n");
	printf("\t\t  ����������������������������������\n");
	printf("\t\t����ѡ��(1-6):");
	cin >> n;

	return n;
}

