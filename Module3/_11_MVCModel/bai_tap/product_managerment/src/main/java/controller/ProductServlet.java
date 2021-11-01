package controller;

import beam.Product;
import service.IProductService;
import service.impl.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = {"/product_servlet","","/123"})
public class ProductServlet extends HttpServlet {
    private final IProductService iProductService = new ProductService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionUser = request.getParameter("actionUser");
        if (actionUser == null) {
            actionUser = "";
        }
        switch (actionUser) {
            case "create":
                createProduct(request,response);
                break;
            case "edit":
                updateProduct(request,response);
                break;
            case "delete":
                deleteProduct(request,response);
                break;
            case "search":
                searchProduct(request,response);
                break;
            default:
                break;
        }
    }

    private void searchProduct(HttpServletRequest request, HttpServletResponse response){
        String nameSearch = request.getParameter("nameSearch");
        List<Product> searchList = this.iProductService.searchByName(nameSearch);
        if (searchList!=null){
            request.setAttribute("searchList",searchList);
            try {
                request.getRequestDispatcher("product/search.jsp").forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                request.getRequestDispatcher("error-404.jsp").forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        this.iProductService.remove(id);
        listProducts(request,response);
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");
        String brand = request.getParameter("brand");
        Product product = this.iProductService.findByID(id);
        RequestDispatcher dispatcher;
        if (product == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            product.setName(name);
            product.setPrice(price);
            product.setDescription(description);
            product.setBrand(brand);
            this.iProductService.update(id,product);
            request.setAttribute("product", product);
            request.setAttribute("message", "product information was updated");
            dispatcher = request.getRequestDispatcher("product/edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response){
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");
        String brand = request.getParameter("brand");
        int id = createID();
        Product product = new Product(id,name,price,description,brand);
        iProductService.save(product);
        listProducts(request,response);
    }

    private int createID(){
        while (true){
            boolean flag = true;
            int id = (int) (Math.random() * 10000);

            for (Product product: iProductService.findAll()) {
                if (id==product.getId()){
                    flag = false;
                }
            }
            if (flag){
                return id;
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionUser = request.getParameter("actionUser");
        if (actionUser == null) {
            actionUser = "";
        }
        switch (actionUser) {
            case "create":
                showCreateForm(request,response);
                break;
            case "edit":
                showEditForm(request,response);
                break;
            case "delete":
                showDeleteForm(request,response);
                break;
            case "view":
                showView(request,response);
                break;
            case "search":
                showSearchForm(request,response);
            default:
                listProducts(request,response);
                break;
        }
    }

    private void showSearchForm(HttpServletRequest request, HttpServletResponse response){
        RequestDispatcher dispatcher;

//        try {
//            response.sendRedirect("product/search.jsp");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        dispatcher = request.getRequestDispatcher("product/search.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showView(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher;
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = iProductService.findByID(id);
        if (product == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("product", product);
            dispatcher = request.getRequestDispatcher("product/view.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response){
        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher("product/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = iProductService.findByID(id);
        request.setAttribute("product",product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/edit.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = iProductService.findByID(id);
        RequestDispatcher dispatcher;
        if (product == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("product", product);
            dispatcher = request.getRequestDispatcher("product/delete.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private void listProducts(HttpServletRequest request, HttpServletResponse response) {
        List<Product> products = this.iProductService.findAll();
        request.setAttribute("products", products);
//        dispatcher(request,response,"index.jsp");

        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void dispatcher(HttpServletRequest request, HttpServletResponse response, String path){
        RequestDispatcher dispatcher = request.getRequestDispatcher(path);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        IProductService iProductService = new ProductService();
        List<Product> products = iProductService.findAll();
        for (Product p:products) {
            System.out.println(p);
        }
    }
}
