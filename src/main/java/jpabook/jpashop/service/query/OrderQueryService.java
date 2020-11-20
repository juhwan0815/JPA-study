package jpabook.jpashop.service.query;

import jpabook.jpashop.api.OrderApiController;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;
// OSIV 끈 거
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderQueryService {

    //    변환로직을 다 여기로 가져온다.
    private final OrderRepository orderRepository;

    public List<OrderDto> ordersV3() {
//         fetch -> 1대 다 관계라 데이터 뻥튀기 -> 중복이 있다. -> distinct 사용에서 중복 X
        List<Order> orders = orderRepository.findAllWithItem();
        List<OrderDto> result = orders.stream()
                .map(o -> new OrderDto(o))
                .collect(toList());
        return result;
//    }
    }
}