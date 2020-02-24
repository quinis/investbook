package ru.portfolio.portfolio.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.portfolio.portfolio.converter.PortfolioEntityConverter;
import ru.portfolio.portfolio.entity.PortfolioEntity;
import ru.portfolio.portfolio.pojo.Portfolio;
import ru.portfolio.portfolio.repository.PortfolioRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class PortfolioRestController extends AbstractRestController<String, Portfolio, PortfolioEntity> {
    private final PortfolioRepository repository;

    public PortfolioRestController(PortfolioRepository repository, PortfolioEntityConverter converter) {
        super(repository, converter);
        this.repository = repository;
    }

    @GetMapping("/portfolios")
    @Override
    public List<PortfolioEntity> get() {
        return super.get();
    }

    @GetMapping("/portfolios/{id}")
    @Override
    public ResponseEntity<PortfolioEntity> get(@PathVariable("id") String id) {
        return super.get(id);
    }

    @PostMapping("/portfolios")
    @Override
    public ResponseEntity<PortfolioEntity> post(@Valid @RequestBody Portfolio object) {
        return super.post(object);
    }

    @PutMapping("/portfolios/{id}")
    @Override
    public ResponseEntity<PortfolioEntity> put(@PathVariable("id") String id,
                                                  @Valid @RequestBody Portfolio object) {
        return super.put(id, object);
    }

    @DeleteMapping("/portfolios/{id}")
    @Override
    public void delete(@PathVariable("id") String id) {
        super.delete(id);
    }

    @Override
    protected Optional<PortfolioEntity> getById(String id) {
        return repository.findByPortfolio(id);
    }

    @Override
    protected String getId(Portfolio object) {
        return object.getPortfolio();
    }

    @Override
    protected Portfolio updateId(String id, Portfolio object) {
        return object.toBuilder().portfolio(id).build();
    }

    @Override
    protected String getLocation() {
        return "/portfolios";
    }
}
