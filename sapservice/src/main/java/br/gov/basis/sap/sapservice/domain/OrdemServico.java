package br.gov.basis.sap.sapservice.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "ordem_servico")
public class OrdemServico {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "id_projeto")
    private Projeto projeto;

    @ManyToOne
    @JoinColumn(name = "id_tipo_situacao")
    private TipoSituacao situacao;

    @Column(name = "dt_proxima_entrega")
    private LocalDate dataProximaEntrega;

    @Column(name = "qtd_defeito_cliente")
    private Integer qtdDefeitosCliente;

    @Column(name = "qtd_defeito_interno")
    private Integer qtdDefeitosInterno;

    @Column(name = "prazo_entrega")
    private LocalDate prazo;

    @Column(name = "qtd_pontos_funcao")
    private Double pontosFuncao;

    @Column(name = "fabrica")
    private String fabrica;

    @OneToMany(mappedBy = "ordemServico", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Sprint> sprints = new ArrayList<>();

}
