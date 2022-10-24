package com.withstudy.repository;

import com.withstudy.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;


public class MemoryMemberRepository implements MemberRepository {

    // 실무에서는 동시성 문제 때문에 ConcurrentHashMap, AtomicLong 사용
    private static Map<Long, Member> store = new HashMap<>();
    // 키 값을 생성하는 변수
    private static long sequence = 0L;

    @Override
    public Member saveMember(Member member) {
        member.setMemberID(++sequence);
        store.put(member.getMemberID(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                // getNmae()이 파라미터로 넘어온 name과 같은 경우에 필터링
                .filter(member -> member.getMemberName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        // store.values()는 Member를 반환한다.
        return new ArrayList<>(store.values());
    }

    @Override
    public Member joinMember(Member member) {
        return null;
    }


    public void clearStore(){
        store.clear();
    }
}
