package modena.infra.usecase.admin;

public class CheckLoggedAdminUsecase {
    private boolean logged;

    public boolean isLogged() {
        return logged;
    }

    public CheckLoggedAdminUsecase() {
        logged = true;
    }
}
