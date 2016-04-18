package femr.data.models.mysql;

/**
 * Created by Jaymi on 4/21/2016.
 */
import femr.data.models.core.IDiagnosis;
import femr.data.models.core.IPatientEncounter;
import femr.data.models.core.IUser;
import org.joda.time.DateTime;
import javax.persistence.*;

@Entity
@Table(name = "problemChange")
public abstract class ProblemChange implements IDiagnosis, IPatientEncounter{

    @Id
    @Column(name = "DateTime", unique = true, nullable = false)
    private DateTime datetime;
    @Column(name = "Doctor", nullable = false)
    private IUser doctor;
    @Column(name = "Diagnosis", nullable = false)
    private String diagnosis;

    @Override
    public DateTime getDateOfMedicalVisit(){return datetime;}
    @Override
    public void setDateOfMedicalVisit(DateTime dateOfMedicalVisit){this.datetime = dateOfMedicalVisit;}

    @Override
    public IUser getDoctor() {return doctor;}

    @Override
    public void setDoctor(IUser doctor) {this.doctor = doctor;}

    @Override
    public String getName() {
        return diagnosis;
    }
    @Override
    public void setName(String name) {
        this.diagnosis = name;
    }
}
