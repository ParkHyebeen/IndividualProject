package com.todo.menu;
public class Menu {

    public static void displaymenu()
    {
        System.out.println();
        System.out.println("<TodoList command manual>");
        System.out.println("1. add - Add a new item");
        System.out.println("2. del - Delete an existing item");
        System.out.println("3. edit - Update an item");
        System.out.println("4. comp - Check the completed task(s)."); 
        System.out.println("5. important <num> - Check the important task."); 
        System.out.println("6. hurry <num> - Check the hurry task."); 
        System.out.println("7. find <keyword> - Search for the title or description");
        System.out.println("8. find_cate <keyword> - Search for the category");
        System.out.println("9. ls - List all items");
        System.out.println("10. ls_cate - List all categories");
        System.out.println("11. ls_name - Sort the list by name in order");
        System.out.println("12. ls_name_desc - Sort the list by name in reverse order");
        System.out.println("13. ls_date - Sort the list by date in order");
        System.out.println("14. ls_date_desc - Sort the list by date in reverse order"); 
        System.out.println("15. ls_comp - Print the completed task"); 
        System.out.println("16. ls_important - Print the important task");
        System.out.println("17. ls_hurry - Print the task which is in hurry.");
        System.out.println("18. reset - Reset all the list.");
        System.out.println("19. exit - (Or press escape key to exit)");
    }
    
    public static void prompt()
    {
    	System.out.print("\nCommand > ");
    }
}
