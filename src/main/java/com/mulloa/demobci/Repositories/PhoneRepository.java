package com.mulloa.demobci.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mulloa.demobci.Model.Phone;

@Repository
public interface PhoneRepository extends JpaRepository<Phone,Integer> {	

}
