package bibliotheque.proxies;

import bibliotheque.bibliofront.modele.*;
import bibliotheque.modele.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name = "bibliocapi", url = "localhost:9090")
public interface BibliothequeProxy {
    @PostMapping("/rechercher-ouvrage")
    List<ResultatExemplaire> getResultatExemplaire(Ouvrage ouvrage);

    @GetMapping("/type-usager")
    List<TypeUser> getListeTypeUsager();

    @PostMapping("/creation-compte")
    void creationCompte(Usager usager);

    @GetMapping("/chercher-usager/{identifiant}")
    Usager chercherUsagerParIdentifiant(@PathVariable("identifiant") String identifiant);

    @GetMapping("/consulter-emprunts/{usagerId}")
    List<Exemplaire> consulterMesEmprunts(@PathVariable("usagerId") Integer usagerId);

    @GetMapping("/prolonger/{exemplaireId}")
    void prolongerEmprunt(@PathVariable("exemplaireId")Integer exemplaireId);
}
