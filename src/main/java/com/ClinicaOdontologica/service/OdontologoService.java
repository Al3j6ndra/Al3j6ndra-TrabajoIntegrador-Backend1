package com.ClinicaOdontologica.service;

import com.ClinicaOdontologica.entity.Odontologo;
import com.ClinicaOdontologica.exception.ResourceNotFoundException;
import com.ClinicaOdontologica.repository.IOdontologoRepository;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService {
    private static final Logger LOGGER = Logger.getLogger(OdontologoService.class);
    private final IOdontologoRepository odontologoRepository;

    public OdontologoService(IOdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }

    public Odontologo guardarOdontologo(Odontologo odontologo) {
        return odontologoRepository.save(odontologo);
    }

    public Odontologo actualizarOdontologo(Odontologo odontologo) {
        return odontologoRepository.save(odontologo);
    }

    public void eliminarOdontologo(Long id) throws ResourceNotFoundException {
        if (buscarOdontologoPorId(id).isPresent()) {
            odontologoRepository.deleteById(id);
        } else {
            LOGGER.warn("No se puede eliminar ese odontologo porque no existe en la db");
            throw new ResourceNotFoundException("No se puede eliminar ese odontologo porque no existe en la db");
        }
    }

    public Optional<Odontologo> buscarOdontologoPorId(Long id) {
        return odontologoRepository.findById(id);
    }

    public Optional<Odontologo> buscarPorMatricula(String matricula) {
        return odontologoRepository.findByMatricula(matricula);
    }

    public List<Odontologo> listarOdontologos() {
        return odontologoRepository.findAll();
    }
}
