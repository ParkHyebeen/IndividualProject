package com.todo.service;

import java.util.*;
import java.io.*;

import com.todo.dao.TodoItem;
import com.todo.dao.TodoList;


public class TodoUtil {
	
	public static void resetItem(TodoList l) {
		int i;
		for(i=1; i<=l.getCount(); i++) {
			if(l.deleteItem(i)>0) {
				continue;
			}else return;
		}
		
		System.out.print("The list is reset.");
		
	}
	
	public static void createItem(TodoList l) {
		
		String title, desc, category, due_date;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("\n[Add]\n"+ "Enter the category > ");
		category = sc.next();
		sc.nextLine();
		
		System.out.print("Enter the title > ");
		title = sc.nextLine().trim();
		
		if (l.isDuplicate(title, l)) {
			System.out.println("Title can't be duplicate!");
			return;
		}
		
		
		System.out.print("Enter the description > ");
		desc = sc.nextLine().trim();
		
		System.out.print("Enter the due date > ");
		due_date = sc.nextLine().trim();
		
		TodoItem i = new TodoItem(category, title, desc, due_date,0, 0, 0);
		if(l.addItem(i) > 0) {
			System.out.println("It's been added.");
		}
	}

	public static void deleteItem(TodoList l, int del) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("[Delete]\n");
		for(int i=0; i<del; i++) {
			System.out.print("Enter the number of item to remove > ");
			int num = sc.nextInt();
		
			if( del == 1) {
				System.out.print("\nDo you want to delete? (y/n) > ");
				String answer = sc.next();
				if(answer.equals("y")) {
					if(l.deleteItem(num) > 0){
						System.out.println("It's been deleted.");
						return;
					}else {
						System.out.println("Item number doesn't exist. Try it again.");
						i--;
						continue;
					}
				}
				else {
					System.out.println("It's been canceled.");
					i--;
					continue;
				}
			}else {
				System.out.print("\nDo you want to delete? (y/n) > ");
				String answer = sc.next();
				if(answer.equals("y")) {
					if(l.deleteItem(num)>0) {
						continue;
					}else {
						System.out.println("Item number doesn't exist. Try it again.");
						i--;
						continue;
					}
					
				}else {
					System.out.println("It's been canceled.");
					i--;
					continue;
				}
			}
				
		}	
		System.out.println("The items are deleted.");
	}
		
	


	public static void updateItem(TodoList l) {
		
		Scanner sc = new Scanner(System.in);
				
		System.out.print("\n[Edit]\n" + "Enter the number of the item you want to update > ");
		int num = sc.nextInt();
	
		System.out.print("Enter the new category > ");
		String new_category = sc.next();
		sc.nextLine();
		
		System.out.print("Enter the new title of the item > ");
		String new_title = sc.nextLine().trim();
		
		System.out.print("Enter the new description > ");
		String new_description = sc.nextLine().trim();
		
		System.out.print("Enter the new due date > ");
		String new_due_date = sc.nextLine().trim();
		
		System.out.print("If you are completed, enter 1. If you are not completed, enter 0. > ");
		int new_is_completed = sc.nextInt();
		sc.nextLine();
		
		System.out.print("If this is important, enter 1. If this is less important, enter 0. > ");
		int new_important = sc.nextInt();
		sc.nextLine();
		
		System.out.print("If you're in a hurry, enter 1. If you have a time, enter 0. > ");
		int new_hurry = sc.nextInt();
		sc.nextLine();
		
		TodoItem i = new TodoItem(new_category, new_title, new_description, new_due_date, new_is_completed, new_important, new_hurry);
		i.setId(num);
		if(l.updateItem(i)>0) {
			System.out.println("It's been edited.");
		}
		else {
			System.out.println("Item number doesn't exist. Try it again.");
		}

	}
	
	public static void find(TodoList l, String string) {
		
		int count = 0;
		for (TodoItem item : l.getList(string)) {
			System.out.println(item.toString());
			count++;
		}
		System.out.println("We found - Total: " +  count);
				
	}
	
	public static void findCate(TodoList l, String string) {
		
		int count = 0;
		for (TodoItem item : l.getListCategory(string)) {
			System.out.println(item.toString());
			count++;
		}
		System.out.println("We found - Total: " +  count);
	}
	
	
	public static void listAll(TodoList l) {
		int num = 0;
		
		System.out.println("[All List, Total: "+ l.getCount() + "]");
		for (TodoItem item : l.getList()) {
			num++;
			System.out.println(num + ". " + item.toString());
		}
	}
	
	public static void listAll(TodoList l, int comp, int important , int hurry) {
		int num = 0;
		
		for (TodoItem item : l.getList(comp, important, hurry)) {
			num++;
			//System.out.println(item.getId() + ". " + item.toString());
			System.out.println(num + ". " + item.toString());
		}
		System.out.println("[All List, Total: "+num + "]");
	}
	
	public static void listAll(TodoList l, String orderby, int ordering) {
		System.out.println("[All List, Total: "+ l.getCount() + "]");
		for(TodoItem item : l.getOrderedList(orderby, ordering)) {
			System.out.println(item.toString());
		}
	}

	public static void listCate(TodoList l) {
		int count = 0;
		for (String item : l.getCategories()) {
			System.out.print(item + " ");;
			count++;
		}
		if(count == 1) System.out.println("\nTotal:" + count + " category is registered.");
		else  System.out.println("\nTotal:" + count + " categories are registered.");
	}
	
	
	
	public static void completeItem(TodoList l, int comp) {
		Scanner sc = new Scanner(System.in);
		System.out.println("[Complete}\n");
		
		for(int i=0; i< comp; i++) {
			System.out.print("Enter the number of item to check complete > ");
			int id = sc.nextInt();
			sc.nextLine();
			
			int check = 0;
			for (TodoItem item : l.getList()) {
				if(item.getId() == id) {
					check = 1;
					item.setIs_completed(1);
					l.completeItem(item);
					break;
				}
			}
			if (check != 1) {
				System.out.println("It doesn't exist.");
				i--;
				continue;
			}
		}
		System.out.println("Completed.");
	}
	
	public static void importantItem(TodoList l, String num) {
		int id = Integer.parseInt(num);
		int check =0;
		for(TodoItem i: l.getList()) {
			if(i.getId() == id) {
				check =1;
				i.setIs_important(1);
				l.importantItem(i);
				System.out.println("Remember this is important.");
				break;
			}
			
		}
		if(check !=1)
			System.out.println("It doesn't exist.");
		
	}
	
	public static void hurryItem(TodoList l,String num) {
		int id = Integer.parseInt(num);
		int check =0;
		for(TodoItem i: l.getList()) {
			if(i.getId() == id) {
				check =1;
				i.setIs_hurry(1);
				l.hurryItem(i);
				System.out.println("Hurry! There's not much time left.");
				break;
			}
			
		}
		if(check !=1)
			System.out.println("It doesn't exist.");
		
	}

	public static void saveList(TodoList l, String filename) {
		try {
			FileWriter w = new FileWriter(filename);
			ArrayList<TodoItem> list = l.getList();
			for (TodoItem item : list) {
				w.write(item.toSaveString());
			}
			
			w.close();
			System.out.println("모든 데이터가 저장되었습니다.");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
}
