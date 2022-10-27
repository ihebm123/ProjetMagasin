package tn.esprit.rh.achat.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.repositories.OperateurRepository;
import tn.esprit.rh.achat.services.OperateurServiceImpl;


@ExtendWith(MockitoExtension.class)

public class OperateurServiceTestMock {
@Mock
OperateurRepository operateurRepository;

@InjectMocks
OperateurServiceImpl operateurService;


@Test
public void retrieveAllOperateursTest() {
when(operateurRepository.findAll()).thenReturn(Stream.of(new Operateur((long)1,"NB","ahmed","pwd", null), new Operateur((long)2,"NB","Nadine","pwd", null),
new Operateur((long)3,"NB","ALI","pwd", null)).collect(Collectors.toList()));
assertEquals(3,operateurService.retrieveAllOperateurs().size());

}

@Test
public void addOperateurTest() {
Operateur op = new Operateur((long)1,"BenHmid","med","pwdd", null) ;
when(operateurRepository.save(op)).thenReturn(op);
assertEquals(op,operateurService.addOperateur(op));
}


@Test
public void retreiveOperateurTest() {
Operateur op = new Operateur((long)2,"Benhmid","med","pwdd", null) ;
when(operateurRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(op));
Operateur op1= operateurService.retrieveOperateur((long)2);
Assertions.assertNotNull(op1);

}



@Test
public void deleteOperateurTest() {
Operateur op = new Operateur((long)1,"BenHmid","med","pwdd", null) ;
operateurService.deleteOperateur((long)1);
verify(operateurRepository).deleteById((long)1);

}

@Test
public void updatetOperateurTest() {
Operateur op = new Operateur((long)1,"Benhmid","med","pwdd", null) ;
Mockito.when(operateurRepository.save(Mockito.any(Operateur.class))).thenReturn(op);
op.setPrenom("mohamed");;
Operateur exisitingOp= operateurService.updateOperateur(op) ;

assertNotNull(exisitingOp);
assertEquals("mohamed", op.getPrenom());
}
}