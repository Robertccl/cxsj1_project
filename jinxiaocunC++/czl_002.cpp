// czl_002.cpp : 定义控制台应用程序的入口点。
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
	//定义对象 

	if (SMIS_SUCCESS == password.Run())//密码检测
	{
		//运行
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
	system("cls"); /*清屏*/
	printf("\t\t ====================================\n");
	printf("\t\t│         销售信息管理系统         │\n");
	printf("\t\t ====================================\n");
	printf("\t\t  ┌───────────────┐\n");
	printf("\t\t  │ 1. 人员管理     2. 商品管理  │\n");
	printf("\t\t  │                              │\n");
	printf("\t\t  │ 3. 进货商管理   4. 顾客管理  │\n");
	printf("\t\t  │                              │\n");
	printf("\t\t  │ 5. 销售管理     0. 退出	  │\n");
	printf("\t\t  └───────────────┘\n");
	printf("\t\t请您选择(1-6):");
	cin >> n;

	return n;
}

