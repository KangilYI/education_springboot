package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class OrderServiceImpl implements OrderService {

	private final MemberRepository memberRepository;
	private final DiscountPolicy discountPolicy;

	/**
	 * @Autowired의 기본동작은 주입할 대상이 없으면 오류가 발생한다.
	 * 주입할 대상이 없어도 동작하게 하려면 @Autowired(required = false) 로 지정하면된다
	 * 생성자가 하나일경우 스프링 컨테이너에서 자동으로 Autowired를 지정한다.
	 */

	@Autowired
	public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
		this.memberRepository = memberRepository;
		this.discountPolicy = discountPolicy;
	}


	@Override
	public Order createOrder(Long memberId, String itemName, int itemPrice) {
		Member member = memberRepository.findById(memberId);
		int discountPrice = discountPolicy.discount(member, itemPrice);

		return new Order(memberId, itemName, itemPrice, discountPrice);
	}

	//test
	public MemberRepository getMemberRepository() {
		return memberRepository;
	}
}
