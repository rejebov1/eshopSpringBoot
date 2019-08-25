package by.vironit.training.danil.eshop.service.dto.converterDTO;

import by.vironit.training.danil.eshop.model.Order;
import by.vironit.training.danil.eshop.model.User;
import by.vironit.training.danil.eshop.service.dto.OrderDTO;
import by.vironit.training.danil.eshop.service.dto.UserDTO;

import java.util.ArrayList;
import java.util.List;

public class UserConverter {

    public static UserDTO toDTO(User user, Boolean loadOrders){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setRole(user.getRole());
        userDTO.setAddress(user.getAddress());
        userDTO.setFullName(user.getFullName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        userDTO.setPhone(user.getPhoneNumber());

        if(loadOrders){
            List<Order> orders = user.getOrders();
            List<OrderDTO> orderDTOList = new ArrayList<>();
            for (Order order: orders) {
                orderDTOList.add(OrderConverter.toDTO(order,user));
            }
            userDTO.setOrders(orderDTOList);
        }
        return userDTO;
    }

    public static User fromDTO(UserDTO userDTO, boolean setOrders){
        User user = new User();
        user.setId(userDTO.getId());
        user.setRole(userDTO.getRole());
        user.setAddress(userDTO.getAddress());
        user.setFullName(userDTO.getFullName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setPhoneNumber(userDTO.getPhone());

        if(userDTO.getOrders() != null && userDTO.getOrders().size() > 0 && setOrders){
            for(OrderDTO orderDTO: userDTO.getOrders()){
                user.getOrders().add(OrderConverter.fromDTO(orderDTO));
            }
        }

        return user;
    }
}
