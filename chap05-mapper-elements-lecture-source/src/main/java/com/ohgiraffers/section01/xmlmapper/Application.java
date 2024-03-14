package com.ohgiraffers.section01.xmlmapper;

import com.ohgiraffers.common.CategoryDTO;
import com.ohgiraffers.common.MenuAndCategoryDTO;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ElementTestService elementTestService = new ElementTestService();

        do{
            System.out.println("===========매퍼 element 테스트 메뉴=========");
            System.out.println("1. <cache> 테스트");
            System.out.println("2. <resultMap> 서브 메뉴");
            System.out.println("3. <sql> 테스트");
            System.out.println("4. <insert> 서브 메뉴");
            System.out.println("메뉴 번호 입력 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1 : elementTestService.selectCacheTest(); break;
                case 2 : resultMapSubMenu(); break;
                case 3 : elementTestService.selectSqlTest(); break;
                case 4 : elementTestService.insertCategoryAndMenuTest(insertMenuAndCategory()); break;
            }
        } while (true);
    }

    private static void resultMapSubMenu() {

        Scanner sc = new Scanner(System.in);
        ElementTestService elementTestService = new ElementTestService();
        do {
            System.out.println("======== <resultMap> 서브 메뉴 =========");
            System.out.println("1. <resultMap> 테스트");
            System.out.println("2. <constructor> 태스트");
            System.out.println("3. <association> 테스트");
            System.out.println("4. <collection> 테스트");
            System.out.println("메뉴 번호를 입력 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1 : elementTestService.selectResultMapTest(); break;
                case 2 : elementTestService.selectResultMapConstructorTest(); break;
                case 3 : elementTestService.selectResultMapAssociationTest(); break;
                case 4 : elementTestService.selectResultMapCollectionTest(); break;
            }
        } while (true);
    }

    private static MenuAndCategoryDTO insertMenuAndCategory() {

        Scanner sc = new Scanner(System.in);
        System.out.println("신규 카테고리명 입력 : ");
        String categoryName = sc.nextLine();
        System.out.println("등록할 메뉴 이름 입력 : ");
        String menuName = sc.nextLine();
        System.out.println("메뉴의 가격을 입력 : ");
        int menuPrice = sc.nextInt();
        sc.nextLine();
        System.out.println("바로 판매 등록 할까요?(y/n) : ");
        String orderableStatus = sc.nextLine();

        MenuAndCategoryDTO menuAndCategory = new MenuAndCategoryDTO();
        CategoryDTO category = new CategoryDTO();

        category.setName(categoryName);

        menuAndCategory.setCategory(category);
        menuAndCategory.setPrice(menuPrice);
        menuAndCategory.setName(menuName);
        menuAndCategory.setOrderableStatus(orderableStatus);

        return menuAndCategory;
    }
}
