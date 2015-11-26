package net.teamlixo.eggcrack.account.output;

import net.teamlixo.eggcrack.EggCrack;
import net.teamlixo.eggcrack.account.Account;
import net.teamlixo.eggcrack.account.AuthenticatedAccount;
import net.teamlixo.eggcrack.credential.Credential;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;

public class FileAccountOutput extends AccountOutput {
    private final File file;
    private String lineSeparator = "\r\n";

    public FileAccountOutput(File file) {
        this.file = file;
    }

    @Override
    public void save(AuthenticatedAccount account) throws IOException {
        synchronized (file) {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));

            bufferedWriter.write(account.getUsername() + ":" + account.getCredential().toString() + lineSeparator);

            bufferedWriter.flush();
            bufferedWriter.close();

            EggCrack.LOGGER.fine("Account " + account.getUsername()
                    + " saved to file \"" + file.getAbsolutePath() + "\".");
        }
    }
}
