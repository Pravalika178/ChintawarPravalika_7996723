import axios from "axios";
import GitClient from "./GitClient";

jest.mock("axios");

describe("Git Client Tests", () => {
  test(
    "should return repository names for techiesyed",
    async () => {
      const mockData = {
        data: [
          { name: "Repo1" },
          { name: "Repo2" },
          { name: "Repo3" }
        ]
      };

      axios.get.mockResolvedValue(mockData);

      const client = new GitClient();

      const repos =
        await client.getRepositories("techiesyed");

      expect(repos).toEqual([
        "Repo1",
        "Repo2",
        "Repo3"
      ]);

      expect(axios.get).toHaveBeenCalledWith(
        "https://api.github.com/users/techiesyed/repos"
      );
    }
  );
});