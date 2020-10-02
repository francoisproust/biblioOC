package bibliotheque.controlleur;

import bibliotheque.modele.TypeUser;
import bibliotheque.proxies.BibliothequeProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TypeUserController {

    private final BibliothequeProxy bibliothequeProxy;

    @Autowired
    public TypeUserController(BibliothequeProxy bibliothequeProxy){
        this.bibliothequeProxy = bibliothequeProxy;
    }


    @GetMapping("/type-usager")
    public List<TypeUser> listerTypeUsager(){
        List<TypeUser> typeUsagers = bibliothequeProxy.getListeTypeUsager();
        return typeUsagers;
    }
}
