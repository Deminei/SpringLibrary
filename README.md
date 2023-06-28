# Spring Library Management System

This is a basic Library Management System built using Spring Boot. It simulates basic operations of a library system, allowing the user to manage books and authors. You can create, read, update and delete both books and authors. 

The primary functionalities include:

**Authors:**

- **Create an Author:** To create a new author, navigate to `/authors/new`. Fill out the form and click submit. You will then be redirected to the author list view.
- **Read (View) Authors:** To view all authors, navigate to `/authors`. This will display a list of all authors in the library system.
- **Update an Author:** To update an author's details, click on the "Edit" button next to the author you want to update in the author list view. You'll be redirected to a form where you can edit the author's details. Submitting the form will update the author's details and redirect you back to the author list view.
- **Delete an Author:** To delete an author, click on the "Delete" button next to the author you want to delete in the author list view. The author will be deleted and you'll remain on the updated author list view.

**Books:**

- **Create a Book:** To create a new book, navigate to `/books/new`. Here's a fun note: Make sure you've created authors before attempting to create a book, as each book needs an author. Our books need their masterminds! Fill out the form and click submit. You'll then be redirected to the book list view.
- **Read (View) Books:** To view all books, navigate to `/books`. This will display a list of all books in the library system.
- **Update a Book:** To update a book's details, click on the "Edit" button next to the book you want to update in the book list view. You'll be redirected to a form where you can edit the book's details. Submitting the form will update the book's details and redirect you back to the book list view.
- **Delete a Book:** To delete a book, click on the "Delete" button next to the book you want to delete in the book list view. The book will be deleted and you'll remain on the updated book list view.

## How to run this project

1. Clone the repository: `git clone https://github.com/Deminei/SpringLibrary.git`
2. Move into the project directory: `SpringLibrary`
3. Run the application: `./mvnw spring-boot:run` (or on IntelliJ, just run the SpringLibraryApplication)
4. Open your web browser and visit `http://localhost:8080` for the home page,
`http://localhost:8080/authors`  to manage authors, 
and `http://localhost:8080/books` to manage books.

## Testing the application

To test the application, simply follow the steps described in the functionalities after running the project.

Remember, our books need their authors! So be sure to create some authors before you create any books. Happy reading and managing!
