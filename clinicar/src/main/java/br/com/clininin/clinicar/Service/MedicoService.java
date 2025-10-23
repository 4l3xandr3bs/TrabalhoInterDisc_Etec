package br.com.clininin.clinicar.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.clininin.clinicar.Entity.Medico;
import br.com.clininin.clinicar.Repository.MedicoRepository;
@Service
public class MedicoService {
    @Autowired
    private MedicoRepository medicoRepository;
    //método para salvar um aluno
    public Medico save(Medico medico ){
        return medicoRepository.save(medico);
  
    }
    //método para listar todos os alunos
    public List<Medico> findAll(){
      return medicoRepository.findAll();
    }
     public void deleteById(Integer id){
        medicoRepository.deleteById(id);
      }
      public Medico findById(Integer id){
          return medicoRepository.findById(id).orElse(null);
      };
}
