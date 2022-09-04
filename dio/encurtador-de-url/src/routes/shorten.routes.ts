import { URLModel } from "../database/model/URL";
import { NextFunction, Request, Response, Router } from "express";
import shortId from 'shortid';
import { config } from '../config/Constants';

const shortenRoute = Router();

shortenRoute.post('/shorten', async (req: Request, res: Response, next: NextFunction): Promise<void> => {
  const { originURL } = req.body;

  const url = await URLModel.findOne({ originURL });

  if(url) {
    res.json(url);
    return;
  }

  const hash = shortId.generate();
  const shortURL = `${config.API_URL}/${hash}`;
  const newUrl = await URLModel.create({ originURL, hash, shortURL });

  res.json(newUrl);
});

shortenRoute.get('/:hash', async (req: Request, res: Response, next: NextFunction): Promise<void> => {
  const { hash } = req.params;
  const url = await URLModel.findOne({ hash });

  if(url && url.originURL) {
    res.redirect(url.originURL);
    return;
  }

  res.status(404).json({ error: 'URL not found.' });
});

export default shortenRoute;
