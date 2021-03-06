package com.invoices.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * The entity that represents a client's portfolio.
 * It has 2 foreign keys. One to indicate the client-owner of the portfolio, which
 * can not be null.
 * The other foreign-key indicates the company that this portfolio belongs
 * to, if and only if the client has his/her own company.
 * @author psoutzis
 */
@Entity
@Table(name = "portfolios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "portfolio_id")
    private Long id;

    @Column(name = "portfolio_code")
    private String portfolioCode;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id")
    private ClientCompanyInfo clientCompanyInfo;
}
