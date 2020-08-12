package br.gov.basis.sap.sapservice.service;

import br.gov.basis.sap.sapservice.repository.LiderRepository;
import br.gov.basis.sap.sapservice.service.dto.LiderDTO;
import br.gov.basis.sap.sapservice.service.mapper.LiderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class LiderServico {

    private final LiderMapper liderMapper;

    private  final LiderRepository liderRepository;

    public List<LiderDTO> obterTodos() {
        return liderMapper.toDto(liderRepository.findAll());
    }

    public LiderDTO obterPorId(Integer id) {
        return new LiderDTO();
    }

    public LiderDTO salvar(LiderDTO lider) {
        return new LiderDTO();
    }

    public void removerPorId(Integer id) {

    }

}