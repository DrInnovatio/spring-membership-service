package hellomaven.HelloSpringmaven.repository;

import hellomaven.HelloSpringmaven.domain.Member;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class jdbcMemberRepository implements MemberRepository {

    private final DataSource dataSource;

    public jdbcMemberRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Member save(Member member) throws SQLException {
        String sql = "insert into member(name) values(?)";

        Connection conn = dataSource.getConnection();
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, member.getName());
        pstmt.executeUpdate();
        return null;
    }
// Lecture 16 다시보기
    @Override
    public Optional<Member> findById(Long is) {
        return Optional.empty();
    }

    @Override
    public Optional<Member> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public List<Member> findAll() {
        return null;
    }

    @Override
    public void clearStore() {

    }
}
