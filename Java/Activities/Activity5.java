package Activity5;

abstract class Book {
  String title;

  abstract void setTitle(String str);

  String getTitle() {
      return title;
  }
}

class MyBook extends Book {
  public void setTitle(String str) {
      title = str;
  }
}
public class Activity5 {
  
  public static void main(String []args) {
      String title = "My Life In Full";
      Book newNovel = new MyBook();
      newNovel.setTitle(title);
      
      System.out.println("The title is: " + newNovel.getTitle());
  }
}
