package co.edu.sena.rocks.servlet;

import co.edu.sena.rocks.bean.User;
import co.edu.sena.rocks.repository.Repository;
import co.edu.sena.rocks.repository.UserRepositoryImpl;
import co.edu.sena.rocks.utiil.DBConection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet ("RegisterProduct")
public class UserRegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //  collect all form data
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        Integer precio = Integer.valueOf(request.getParameter("precio"));
        Integer cantidad = Integer.valueOf(request.getParameter("cantidad"));


        //  fill it up in a User Bean
        User user = new User();
        user.setNombre(nombre);
        user.setDescripcion(descripcion);
        user.setPrecio(Integer.valueOf(precio));
        user.setCantidad(Integer.valueOf(cantidad));


        // call repository layer and save the user object to DB
        String opcion = request.getParameter("opcion");
        Repository<User> repository = new UserRepositoryImpl();

        int rows = 0;

        try {
            rows = repository.saveObj(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //  prepare information message for user about sucess or fallure of the console

        if (rows == 0) {
            //infoMessage = "Ocurrio un error";
            System.out.println("Ocurrio un error");
        } else {
            //infoMessage = "Registro exitoso";
            System.out.println("registro existoso");
        }
        break;
    
        switch(opcion) {
    
    case"eliminardatos":

    {

        try {
            Repository.deleteObj(User.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        break;
    }
    case"abrirdatos":

    {

        try {
            User datos = Repository.byIdOBj(User.getId());
            .getSession().setAttribute("datos", datos);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        break;
    }
}
}
}


