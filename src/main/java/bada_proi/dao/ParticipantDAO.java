package bada_proi.dao;

import bada_proi.entity.Address;
import bada_proi.entity.Participant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ParticipantDAO {

    @Autowired
    private final JdbcTemplate jdbcTemplate;


    public ParticipantDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * @return list of participants got from database
     */
    public List<Participant> list() {
        String sql = "SELECT * FROM PARTICIPANTS";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Participant.class));
    }

    // CRUD methods
    /** Insert */
    public void save(Participant participant){
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("participants").usingColumns("participantId","name","surname","birthDate","pesel","gender","phoneNumber","email","addressId","userId");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(participant);
        insertActor.execute(param);
    }
    /** Read */
    public Participant get(int id){
        Object[] args = {id};
        String sql = "SELECT * FROM PARTICIPANTS WHERE participantId = " + args[0];
        return jdbcTemplate.queryForObject(sql,BeanPropertyRowMapper.newInstance(Participant.class));
    }
    /** Update */
    public void update(Participant participant){
        String sql = "UPDATE PARTICIPANTS SET name=:name , surname=:surname , birthDate=:birthDate , pesel=:pesel , gender=:gender , phoneNumber=:phoneNumber , email=:email , addressId=:addressId, userId=:userId WHERE participantId=:participantId";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(participant);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql,param);
    }
    /** Delete */
    public void delete(int id){
        String sql = "DELETE FROM PARTICIPANTS WHERE participantId = ?";
        jdbcTemplate.update(sql,id);
    }
    //TODO
    /*public List<Integer> getActiveCourses(int participantId){
        return new List<Integer>(){Integer.valueOf(0)};
    }*/
}
