package com.example.prueba.service;

import com.example.prueba.models.User;
import com.example.prueba.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User findById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

    public User update(User user) {
        // Verifica si el usuario existe en la base de datos
        User userDB = this.findById(user.getId());
        if (userDB == null) {
            return null;
        }

        // Actualiza los campos no nulos del usuario existente
        updateNonNullFields(userDB, user);

        // Guarda el usuario actualizado en la base de datos
        return userRepository.save(userDB);
    }

    private void updateNonNullFields(Object target, Object source) {
        // Obtiene todos los campos declarados en la clase
        Field[] fields = source.getClass().getDeclaredFields();

        for (Field field : fields) {
            try {
                // Hace que el campo sea accesible, incluso si es privado
                field.setAccessible(true);

                // Obtiene el valor del campo en el objeto source
                System.out.println("field = " + field);
                Object value = field.get(source);
                System.out.println("value = " + value);
                // Si el valor no es nulo, actualiza el campo en el objeto target
                if (value != null) {
                    field.set(target, value);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace(); // Maneja adecuadamente la excepción en tu aplicación
            } finally {
                field.setAccessible(false);
            }
        }
    }


}
