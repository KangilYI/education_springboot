package hello.core.member;

import javax.management.MBeanServerDelegateMBean;

public interface MemberRepository {

	void save(Member member);

	Member findById(Long memberId);
}
