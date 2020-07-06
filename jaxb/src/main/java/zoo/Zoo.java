package zoo;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlType(name = "zoo")
@XmlRootElement
public class Zoo {
    @XmlElementWrapper(name = "wild-animals", nillable = true)
    public List<Animal> animals = new ArrayList();
}

